package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import ru.blockfinder.util.behavior.Behavior;

import java.awt.*;

public interface MapColorBehavior {

    Color getMapColor(Behavior<Executor> behavior, Block block);

    @FunctionalInterface
    interface Executor {

        Color execute(Block block);
    }
}
