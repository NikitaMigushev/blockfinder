package ru.blockfinder.model.blockentity;

import ru.blockfinder.util.data.BlockColor;

public interface Cauldron extends BlockEntity {

    short getPotionId();

    void setPotionId(int potionId);

    short getPotionType();

    void setPotionType(int potionType);

    boolean isSplash();

    void setSplash(boolean splash);

    BlockColor getCustomColor();

    void setCustomColor(BlockColor color);

    boolean hasCustomColor();
}
