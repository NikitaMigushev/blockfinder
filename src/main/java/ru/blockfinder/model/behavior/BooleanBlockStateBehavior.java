package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.BlockState;
import ru.blockfinder.util.behavior.Behavior;

public interface BooleanBlockStateBehavior {

    boolean test(Behavior<Executor> behavior, BlockState block);

    @FunctionalInterface
    interface Executor {
        boolean execute(BlockState block);
    }
}
