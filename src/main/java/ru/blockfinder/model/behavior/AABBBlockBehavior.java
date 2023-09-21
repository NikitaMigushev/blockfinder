package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.BlockState;
import ru.blockfinder.util.AxisAlignedBB;
import ru.blockfinder.util.behavior.Behavior;

public interface AABBBlockBehavior {

    AxisAlignedBB getBoundingBox(Behavior<Executor> behavior, BlockState state);

    @FunctionalInterface
    interface Executor {
        AxisAlignedBB execute(BlockState state);
    }
}
