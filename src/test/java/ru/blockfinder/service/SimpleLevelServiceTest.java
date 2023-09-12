package ru.blockfinder.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

class SimpleLevelServiceTest {
    private static LevelService service;

    @BeforeAll
    public static void init() throws IOException {
        service = new SimpleLevelService(Path.of("./world"));
    }

    @Test
    public void createJsonWithFoundEntities() {
        try {
            var chunks = service.findChunksWithEntitiesByName("Chest");
            service.createJsonForFindChunksWithEntitiesByName(chunks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createJsonForFindTagsByName() {
        try {
            var tags = service.findTagsByName("Chest");
            service.createJsonForFindTagsByName(tags);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}