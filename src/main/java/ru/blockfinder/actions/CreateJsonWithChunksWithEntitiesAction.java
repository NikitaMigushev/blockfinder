package ru.blockfinder.actions;

import ru.blockfinder.service.LevelService;

public class CreateJsonWithChunksWithEntitiesAction implements UserAction {

    public final Output out;

    public CreateJsonWithChunksWithEntitiesAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create JSON with Chunks with entities";
    }

    @Override
    public boolean execute(Input input, LevelService service) {
        out.println("=== Create JSON with Chunks with entities ===");
        String name = input.askStr("Enter entity name: ");
        try {
            var chunks = service.findChunksWithEntitiesByName(name);
            if (chunks.isEmpty() || chunks == null) {
                out.println("No chunks have been found with this entity");
            } else {
                service.createJsonForFindChunksWithEntitiesByName(chunks);
                out.println("Json has been created");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
