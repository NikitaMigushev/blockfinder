package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.Block;
import ru.blockfinder.util.behavior.Behavior;

public interface BooleanBlockBehavior {

    boolean test(Behavior<Executor> behavior, Block block);

    @FunctionalInterface
    interface Executor {
        boolean execute(Block block);
    }
}
