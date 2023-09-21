package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.BlockState;
import ru.blockfinder.util.behavior.Behavior;

public interface DescriptionBlockBehavior {

    String getDescription(Behavior<Executor> behavior, BlockState state);

    @FunctionalInterface
    interface Executor {
        String execute(BlockState state);
    }
}
