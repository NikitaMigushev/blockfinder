package ru.blockfinder.serializer;

import io.netty.buffer.ByteBuf;
import ru.blockfinder.model.block.BlockStorage;
import ru.blockfinder.model.chunk.SimpleChunk;

public interface ChunkSectionSerializer {
    BlockStorage[] deserialize(ByteBuf buf, SimpleChunk simpleChunk);
}
