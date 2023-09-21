package ru.blockfinder.model.blockentity;

import ru.blockfinder.model.block.BlockState;

public interface FlowerPot extends BlockEntity {

    BlockState getPlant();

    void setPlant(BlockState blockState);
}
