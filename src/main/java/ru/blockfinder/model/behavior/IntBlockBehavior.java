package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.BlockState;
import ru.blockfinder.util.behavior.Behavior;

public interface IntBlockBehavior {

    int getProperty(Behavior<Executor> behavior, BlockState state);

    @FunctionalInterface
    interface Executor {
        int execute(BlockState state);
    }
}
