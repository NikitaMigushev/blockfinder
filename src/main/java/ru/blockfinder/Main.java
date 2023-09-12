package ru.blockfinder;

import ru.blockfinder.service.LevelService;
import ru.blockfinder.service.SimpleLevelService;

import java.nio.file.Path;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        try {
            LevelService service = new SimpleLevelService(Path.of(argsName.get("p")));
            String function = argsName.get("f");

            switch (function) {
                case "chunk":
                    var chunks = service.findChunksWithEntitiesByName(argsName.get("s"));
                    if (chunks.isEmpty() || chunks == null) {
                        System.out.println("No chunks have been found with this entity");
                    } else {
                        service.createJsonForFindChunksWithEntitiesByName(chunks);
                        System.out.println("JSON with chunks has been created");
                    }
                    break;
                case "tag":
                    var tags = service.findTagsByName(argsName.get("s"));
                    if (tags.isEmpty() || tags == null) {
                        System.out.println("No tags have been found with this entity");
                    } else {
                        service.createJsonForFindTagsByName(tags);
                        System.out.println("JSON with tags has been created");
                    }
                    break;
                case "unique":
                    Set<String> entities = service.getUniqueEntities();
                    if (entities.isEmpty() || entities == null) {
                        System.out.println("Entities haven't been found");
                    } else {
                        service.createJsonWithUniqueEntities(entities);
                        System.out.println("JSON with unique entities has been created");
                    }
                    break;
                default:
                    break;
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
