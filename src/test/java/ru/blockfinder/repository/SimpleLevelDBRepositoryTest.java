package ru.blockfinder.repository;

import org.junit.jupiter.api.Test;
import ru.blockfinder.model.chunk.SimpleChunk;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleLevelDBRepositoryTest {


    @Test
    public void getAllChunksTest() {
        var chunksWithTags = new HashSet<SimpleChunk>();
        try {
            SimpleLevelDBRepository repository = new SimpleLevelDBRepository(Path.of("C:\\world"));
            var result = repository.getAllChunks();
            System.out.println("Check here");

            for (SimpleChunk chunk : result) {
                if (chunk.getTags() != null && chunk.getTags().size() > 0) {
                    chunksWithTags.add(chunk);
                }
            }
            repository.getDb().close();
            assertThat(chunksWithTags).isNotEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findChunksWithEntitiesTest() {
        try {
            SimpleLevelDBRepository repository = new SimpleLevelDBRepository(Path.of("C:\\world"));
            var result = repository.findChunksWithEntitiesByName("Chest");
            System.out.println("check here");
            assertThat(result).isNotEmpty();
            repository.getDb().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findChunksWithEntitiesByNamesTest() {
        try {
            SimpleLevelDBRepository repository = new SimpleLevelDBRepository(Path.of("C:\\world"));
            var result = repository.findChunksWithEntitiesByName(List.of("Skull", "FlowerPot").toArray(new String[0]));
            System.out.println("check here");
            assertThat(result).isNotEmpty();
            repository.getDb().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUniqueEntitiesTest() {
        try {
            SimpleLevelDBRepository repository = new SimpleLevelDBRepository(Path.of("C:\\world"));
            var result = repository.getUniqueEntities();
            assertThat(result).isNotEmpty();
            repository.getDb().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findTagsByName() {
        try {
            SimpleLevelDBRepository repository = new SimpleLevelDBRepository(Path.of("C:\\world"));
            var result = repository.findTagsByName("Chest");
            System.out.println("check here");
            assertThat(result).isNotEmpty();
            repository.getDb().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}