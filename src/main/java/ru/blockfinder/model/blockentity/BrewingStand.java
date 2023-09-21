package ru.blockfinder.model.blockentity;

import org.cloudburstmc.api.container.view.BlockContainerView;
import ru.blockfinder.model.item.ItemStack;

public interface BrewingStand extends BlockEntity, BlockContainerView {

    short getCookTime();

    void setCookTime(int cookTime);

    short getFuelAmount();

    void setFuelAmount(int fuelAmount);

    ItemStack getIngredient();

    void setIngredient(ItemStack ingredient);

    ItemStack getFuel();

    void setFuel(ItemStack fuel);
}
