package ru.blockfinder.model;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import org.cloudburstmc.nbt.NBTInputStream;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.nbt.NbtUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class BlockStorage {
    private static final int SIZE = 4096;
    private final List<NbtMap> palette = new ArrayList<>();
    private BitArray bitArray;

    public void readFromStorage(ByteBuf buf) {
        BitArrayVersion version = getVersionFromHeader(buf.readByte());
        int expectedWordCount = version.getWordsForSize(SIZE);
        int[] words = new int[expectedWordCount];
        for (int i = 0; i < expectedWordCount; i++) {
            words[i] = buf.readIntLE();
        }
        this.bitArray = version.createPalette(SIZE, words);
        this.palette.clear();
        int paletteSize = buf.readIntLE();

        checkArgument(version.getMaxEntryValue() >= paletteSize - 1,
                "Palette is too large. Max size %s. Actual size %s", version.getMaxEntryValue(),
                paletteSize);

        try (ByteBufInputStream stream = new ByteBufInputStream(buf);
             NBTInputStream nbtInputStream = NbtUtils.createReaderLE(stream)) {
            for (int i = 0; i < paletteSize; i++) {
                try {
                    NbtMap tag = (NbtMap) nbtInputStream.readTag();
                    palette.add(tag);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("check here");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BitArrayVersion getVersionFromHeader(byte header) {
        return BitArrayVersion.get(header >> 1, true);
    }
}
