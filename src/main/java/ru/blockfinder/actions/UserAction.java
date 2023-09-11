package ru.blockfinder.actions;

import ru.blockfinder.service.LevelService;

public interface UserAction {
    String name();

    boolean execute(Input input, LevelService service);
}
