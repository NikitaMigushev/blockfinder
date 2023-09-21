package ru.blockfinder.serializer;

import it.unimi.dsi.fastutil.ints.Int2ShortMap;
import org.iq80.leveldb.DB;
import ru.blockfinder.model.chunk.SimpleChunk;

public interface ChunkSerializer {
    Int2ShortMap getExtraData();

    void deserialize(DB db, SimpleChunk simpleChunk);
}
