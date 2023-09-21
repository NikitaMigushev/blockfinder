package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import ru.blockfinder.util.behavior.Behavior;

public interface NeighborBlockBehavior {

    void onNeighborChanged(Behavior<Executor> behavior, Block block, Block neighbor);

    @FunctionalInterface
    interface Executor {
        void executor(Block block, Block neighbor);
    }
}
