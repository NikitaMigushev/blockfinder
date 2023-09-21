package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.entity.misc.DroppedItem;
import ru.blockfinder.model.block.Block;
import ru.blockfinder.model.item.ItemStack;
import ru.blockfinder.util.behavior.Behavior;

public interface DropResourceBlockBehavior {

    DroppedItem dropResource(Behavior<Executor> behavior, Block block, ItemStack itemStack);

    @FunctionalInterface
    interface Executor {

        DroppedItem execute(Block block, ItemStack itemStack);
    }
}
