package ru.blockfinder.actions;

import ru.blockfinder.service.LevelService;

public class CreateJsonWithTagsByNameAction implements UserAction {
    public final Output out;

    public CreateJsonWithTagsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create JSON with tags by entity";
    }

    @Override
    public boolean execute(Input input, LevelService service) {
        out.println("=== Create JSON with tags by entity ===");
        String name = input.askStr("Enter entity name: ");
        try {
            var chunks = service.findTagsByName(name);
            if (chunks.isEmpty() || chunks == null) {
                out.println("No tags have been found with this entity");
            } else {
                service.createJsonForFindTagsByName(chunks);
                out.println("Json has been created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
