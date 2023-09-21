package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.Block;
import ru.blockfinder.model.item.ItemStack;
import ru.blockfinder.util.behavior.Behavior;

public interface CanBreakBlockBehavior {

    boolean canBreak(Behavior<Executor> behavior, Block block, ItemStack item);

    @FunctionalInterface
    interface Executor {
        boolean execute(Block block, ItemStack item);
    }
}
