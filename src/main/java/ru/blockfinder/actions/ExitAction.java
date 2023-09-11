package ru.blockfinder.actions;

import ru.blockfinder.service.LevelService;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, LevelService service) {
        out.println("=== Have a nice day! ===");
        return false;
    }
}
