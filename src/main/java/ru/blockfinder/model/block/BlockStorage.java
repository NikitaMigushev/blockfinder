package ru.blockfinder.model.block;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import lombok.extern.log4j.Log4j2;
import org.cloudburstmc.api.block.BlockState;
import org.cloudburstmc.nbt.NBTInputStream;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.nbt.NbtUtils;
import ru.blockfinder.model.BitArray;
import ru.blockfinder.model.BitArrayVersion;

import java.io.IOException;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static ru.blockfinder.model.block.BlockStates.AIR;

@Log4j2
public class BlockStorage {
    private static final int SIZE = 4096;

    private final List<BlockState> palette;
    private BitArray bitArray;

    public BlockStorage() {
        this(BitArrayVersion.V2);
    }

    public BlockStorage(BitArrayVersion version) {
        this.bitArray = version.createPalette(SIZE);
        this.palette = new ReferenceArrayList<>(16);
        this.palette.add(org.cloudburstmc.api.block.BlockStates.AIR); // Air is at the start of every palette.
    }

    private BlockStorage(BitArray bitArray, List<BlockState> palette) {
        this.palette = palette;
        this.bitArray = bitArray;
    }

    public BlockState getBlock(int index) {
        return this.blockFor(this.bitArray.get(index));
    }

    private BlockState blockFor(int index) {
        return this.palette.get(index);
    }

    private int getPaletteHeader(BitArrayVersion version, boolean runtime) {
        return (version.getId() << 1) | (runtime ? 1 : 0);
    }

    private static BitArrayVersion getVersionFromHeader(byte header) {
        return BitArrayVersion.get(header >> 1, true);
    }



    public void readFromStorage(ByteBuf buffer) {
        BitArrayVersion version = getVersionFromHeader(buffer.readByte());

        int expectedWordCount = version.getWordsForSize(SIZE);
        int[] words = new int[expectedWordCount];
        for (int i = 0; i < expectedWordCount; i++) {
            words[i] = buffer.readIntLE();
        }
        this.bitArray = version.createPalette(SIZE, words);

        this.palette.clear();
        int paletteSize = buffer.readIntLE();

        checkArgument(version.getMaxEntryValue() >= paletteSize - 1,
                "Palette is too large. Max size %s. Actual size %s", version.getMaxEntryValue(),
                paletteSize);

        try (ByteBufInputStream stream = new ByteBufInputStream(buffer);
             NBTInputStream nbtInputStream = NbtUtils.createReaderLE(stream)) {
            for (int i = 0; i < paletteSize; i++) {
                try {
                    NbtMap tag = (NbtMap) nbtInputStream.readTag();

                    BlockState state = CloudBlockRegistry.REGISTRY.getBlock(tag);

                    if (this.palette.contains(state)) {
                        log.warn("Palette contains block state ({}) twice! ({}) (palette: {})", state, tag, this.palette);
                    }

                    this.palette.add(state);
                } catch (Exception e) {
                    log.throwing(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
