package ru.blockfinder.model.behavior;

import org.cloudburstmc.api.block.BlockState;
import ru.blockfinder.util.behavior.Behavior;

import java.util.random.RandomGenerator;

public interface ExpBlockBehavior {

    int getExperience(Behavior<Executor> behavior, BlockState state, RandomGenerator random);

    @FunctionalInterface
    interface Executor {
        int execute(BlockState state, RandomGenerator random);
    }
}
