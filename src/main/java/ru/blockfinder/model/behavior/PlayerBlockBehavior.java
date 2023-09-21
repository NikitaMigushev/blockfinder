package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import org.cloudburstmc.api.player.Player;
import ru.blockfinder.util.behavior.Behavior;

public interface PlayerBlockBehavior {

    void execute(Behavior<Executor> behavior, Block block, Player player);

    @FunctionalInterface
    interface Executor {
        void execute(Block block, Player player);
    }
}
