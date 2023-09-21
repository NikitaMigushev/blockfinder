package ru.blockfinder.model.behavior;

import ru.blockfinder.model.block.Block;
import ru.blockfinder.util.behavior.Behavior;

import javax.swing.text.html.parser.Entity;

public interface EntityBlockBehavior {

    void execute(Behavior<Executor> behavior, Block block, Entity entity);

    @FunctionalInterface
    interface Executor {
        void execute(Block block, Entity entity);
    }
}
