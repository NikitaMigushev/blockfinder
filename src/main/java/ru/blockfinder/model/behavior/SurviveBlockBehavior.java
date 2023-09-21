package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import ru.blockfinder.util.behavior.Behavior;

public interface SurviveBlockBehavior {

    boolean canSurvive(Behavior<Executor> behavior, Block block);

    @FunctionalInterface
    interface Executor {
        boolean execute(Block block);
    }
}
