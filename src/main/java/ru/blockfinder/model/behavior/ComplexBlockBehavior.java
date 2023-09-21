package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.Block;
import ru.blockfinder.util.behavior.Behavior;

public interface ComplexBlockBehavior {

    void execute(Behavior<Executor> behavior, Block block);

    @FunctionalInterface
    interface Executor {
        void execute(Block block);
    }
}
