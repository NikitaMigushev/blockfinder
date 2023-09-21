package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import ru.blockfinder.util.behavior.Behavior;

public interface GenericBlockBehavior<T> {

    void execute(Behavior<Executor<T>> behavior, Block block);

    @FunctionalInterface
    interface Executor<T> {
        void execute(Block block);
    }
}
