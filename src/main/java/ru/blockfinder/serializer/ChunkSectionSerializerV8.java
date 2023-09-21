package ru.blockfinder.serializer;

import io.netty.buffer.ByteBuf;
import ru.blockfinder.model.BlockStorage;
import ru.blockfinder.model.SimpleChunk;

public class ChunkSectionSerializerV8 implements ChunkSectionSerializer {
    static final ChunkSectionSerializer INSTANCE = new ChunkSectionSerializerV8();

    @Override
    public BlockStorage[] deserialize(ByteBuf buf, SimpleChunk simpleChunk) {
        int storageCount = buf.readUnsignedByte();
        BlockStorage[] storage = new BlockStorage[Math.max(storageCount, 2)];

        for (int i = 0; i < storageCount; i++) {
            storage[i] = new BlockStorage();
            storage[i].readFromStorage(buf);
        }
        return storage;
    }
}
