package ru.blockfinder.model.blockentity;

import ru.blockfinder.util.data.DyeColor;

public interface Bed extends BlockEntity {

    DyeColor getColor();

    void setColor(DyeColor color);
}
