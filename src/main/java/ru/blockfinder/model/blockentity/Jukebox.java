package ru.blockfinder.model.blockentity;

import ru.blockfinder.model.item.ItemStack;

public interface Jukebox extends BlockEntity {

    ItemStack getRecordItem();

    void setRecordItem(ItemStack recordItem);

    void play();

    void stop();

    void dropItem();
}
