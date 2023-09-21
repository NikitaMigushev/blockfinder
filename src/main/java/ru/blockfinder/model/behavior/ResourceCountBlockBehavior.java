package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.Block;
import ru.blockfinder.util.behavior.Behavior;

import java.util.random.RandomGenerator;

public interface ResourceCountBlockBehavior {

    int getResourceCount(Behavior<Executor> behavior, Block block, RandomGenerator random, int bonusLevel);

    @FunctionalInterface
    interface Executor {
        int execute(Block block, RandomGenerator random, int bonusLevel);
    }
}
