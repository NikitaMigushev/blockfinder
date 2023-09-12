package ru.blockfinder.service;

import org.cloudburstmc.nbt.NbtMap;
import ru.blockfinder.model.SimpleChunk;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface LevelService {
    Set<SimpleChunk> getAllChunks() throws IOException;
    Set<SimpleChunk> findChunksWithEntitiesByName(String name) throws IOException;
    Set<String> getUniqueEntities() throws IOException;

    void createJsonWithUniqueEntities(Set<String> entities) throws IOException;

    void createJsonForFindChunksWithEntitiesByName(Set<SimpleChunk> chunks) throws IOException;
    List<NbtMap> findTagsByName(String name) throws IOException;
    void createJsonForFindTagsByName(List<NbtMap> tags) throws IOException;
}
