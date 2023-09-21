package ru.blockfinder.model.item.behavior;

import ru.blockfinder.model.block.Block;
import ru.blockfinder.model.item.ItemStack;
import ru.blockfinder.util.behavior.Behavior;

public interface CanBePlacedOnBehavior {

    boolean get(Behavior<Executor> behavior, ItemStack item, Block block);

    @FunctionalInterface
    interface Executor {

        boolean execute(ItemStack itemStack, Block block);
    }
}
