package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import org.cloudburstmc.api.entity.Entity;
import ru.blockfinder.util.behavior.Behavior;

public interface FallOnBlockBehavior {

    void onFallOn(Behavior<Executor> behavior, Block block, Entity entity);

    @FunctionalInterface
    interface Executor {
        void execute(Block block, Entity entity);
    }
}
