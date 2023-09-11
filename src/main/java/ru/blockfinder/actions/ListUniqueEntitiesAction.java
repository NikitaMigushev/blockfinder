package ru.blockfinder.actions;

import ru.blockfinder.service.LevelService;

import java.util.Set;

public class ListUniqueEntitiesAction implements UserAction {
    private final Output out;

    public ListUniqueEntitiesAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show unique entities";
    }

    @Override
    public boolean execute(Input input, LevelService service) {
        out.println("=== Show all entities ===");
        try {
            Set<String> entities = service.getUniqueEntities();
            if (entities.isEmpty() || entities == null) {
                out.println("Entities hasn't been found");
            } else {
                for (String entity : entities) {
                    out.println(entity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
