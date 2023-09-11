package ru.blockfinder.actions;

import ru.blockfinder.Main;
import ru.blockfinder.service.LevelService;

public class ShowPathAction implements UserAction {
    private final Output out;

    public ShowPathAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show path";
    }

    @Override
    public boolean execute(Input input, LevelService service) {
        out.println("=== Show path ===");
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        out.println(path);
        return true;
    }
}
