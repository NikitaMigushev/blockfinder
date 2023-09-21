package ru.blockfinder.model.blockentity;

import ru.blockfinder.model.item.ItemStack;

public interface ItemFrame extends BlockEntity {

    int getItemRotation();

    void setItemRotation(int itemRotation);

    ItemStack getItem();

    void setItem(ItemStack item);

    float getItemDropChance();

    void setItemDropChance(float itemDropChance);

    int getAnalogOutput();
}
