package ru.blockfinder.repository;

import org.cloudburstmc.nbt.NbtMap;
import org.iq80.leveldb.DB;
import ru.blockfinder.model.chunk.SimpleChunk;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface LevelDBRepository {
    DB getDb();

    Set<SimpleChunk> getAllChunks() throws IOException;

    Set<Integer> getAllSubchunkVersions() throws IOException;

    Set<SimpleChunk> findChunksWithEntitiesByName(String name) throws IOException;
    Set<String> getUniqueEntities() throws IOException;

    Set<SimpleChunk> findChunksWithEntitiesByName(String[] names) throws IOException;

    List<NbtMap>  findTagsByName(String name) throws IOException;

    List<NbtMap> findTagsByName(String[] names) throws IOException;
}
