package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.BlockState;
import ru.blockfinder.util.behavior.Behavior;

public interface FloatBlockBehavior {

    float getProperty(Behavior<Executor> behavior, BlockState state);

    @FunctionalInterface
    interface Executor {
        float execute(BlockState state);
    }
}
