package ru.blockfinder.model.item.behavior;

import ru.blockfinder.model.item.ItemStack;
import ru.blockfinder.util.behavior.Behavior;

public interface BooleanItemBehavior {

    boolean get(Behavior<Executor> behavior, ItemStack itemStack);

    @FunctionalInterface
    interface Executor {

        boolean execute(ItemStack itemStack);
    }
}
