package ru.blockfinder.serializer;

import io.netty.buffer.ByteBuf;
import ru.blockfinder.model.BlockStorage;
import ru.blockfinder.model.SimpleChunk;

public interface ChunkSectionSerializer {
    BlockStorage[] deserialize(ByteBuf buf, SimpleChunk simpleChunk);
}
