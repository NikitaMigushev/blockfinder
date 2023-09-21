package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.Block;
import ru.blockfinder.util.behavior.Behavior;
import ru.blockfinder.util.data.BlockColor;

public interface ColorBlockBehavior {

    BlockColor execute(Behavior<Executor> behavior, Block block);

    @FunctionalInterface
    interface Executor {
        BlockColor execute(Block block);
    }
}
