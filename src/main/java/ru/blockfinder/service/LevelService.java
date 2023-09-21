package ru.blockfinder.service;

import org.cloudburstmc.nbt.NbtMap;
import ru.blockfinder.model.chunk.SimpleChunk;
import ru.blockfinder.repository.LevelDBRepository;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface LevelService {
    LevelDBRepository getRepository();

    Set<SimpleChunk> getAllChunks() throws IOException;
    Set<SimpleChunk> findChunksWithEntitiesByName(String name) throws IOException;

    Set<SimpleChunk> findChunksWithEntitiesByName(String[] names) throws IOException;

    Set<String> getUniqueEntities() throws IOException;

    void createJsonWithUniqueEntities(Set<String> entities) throws IOException;

    void createJsonForFindChunksWithEntitiesByName(Set<SimpleChunk> chunks) throws IOException;
    List<NbtMap> findTagsByName(String name) throws IOException;
    void createJsonForFindTagsByName(List<NbtMap> tags) throws IOException;

    List<NbtMap> findTagsByName(String[] names) throws IOException;


}
