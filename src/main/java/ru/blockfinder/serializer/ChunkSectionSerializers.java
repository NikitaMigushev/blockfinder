package ru.blockfinder.serializer;

import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;
import ru.blockfinder.model.block.BlockStorage;
import ru.blockfinder.model.chunk.SimpleChunk;

public class ChunkSectionSerializers {
    private static final ChunkSectionSerializer[] SERIALIZERS = new ChunkSectionSerializer[9];

    static {
        SERIALIZERS[0] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[1] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[2] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[3] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[4] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[5] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[6] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[7] = ChunkSectionSerializerV8.INSTANCE;
        SERIALIZERS[8] = ChunkSectionSerializerV8.INSTANCE;
    }

    public static BlockStorage[] deserialize(ByteBuf buf, SimpleChunk simpleChunk, int version) {
        return getSerializer(version).deserialize(buf, simpleChunk);
    }

    public static ChunkSectionSerializer getSerializer(int version) {
        Preconditions.checkElementIndex(version, SERIALIZERS.length, "Invalid sub-chunk version " + version);
        return SERIALIZERS[version];
    }


}
