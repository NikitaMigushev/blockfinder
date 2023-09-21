package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import org.cloudburstmc.api.util.Direction;
import ru.blockfinder.util.behavior.Behavior;

public interface MayPlaceBlockBehavior {

    boolean mayPlace(Behavior<Executor> behavior, Block block, Direction direction);

    @FunctionalInterface
    interface Executor {
        boolean execute(Block block, Direction direction);
    }
}
