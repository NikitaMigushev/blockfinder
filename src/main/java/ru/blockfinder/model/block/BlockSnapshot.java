package ru.blockfinder.model.block;

import static ru.blockfinder.model.block.BlockStates.AIR;

public interface BlockSnapshot {

    default BlockState getState() {
        return getState(0);
    }

    default BlockState getExtra() {
        return getState(1);
    }

    BlockState getState(int layer);

    default int getLiquidLayer() {
        BlockState state = getExtra();
        if (state == AIR) {
            return 0;
        }
        return 1;
    }

    default BlockState getLiquid() {
        BlockState state = getExtra();
        if (state == AIR) {
            return getState();
        }
        return state;
    }
}
