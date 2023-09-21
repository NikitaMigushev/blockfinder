package ru.blockfinder.model.blockentity;

import org.cloudburstmc.api.container.view.BlockContainerView;
import ru.blockfinder.model.item.ItemStack;

public interface Furnace extends BlockEntity, BlockContainerView {

    ItemStack getResult();

    void setResult(ItemStack item);

    ItemStack getFuel();

    void setFuel(ItemStack item);

    ItemStack getSmelting();

    void setSmelting(ItemStack item);
}
