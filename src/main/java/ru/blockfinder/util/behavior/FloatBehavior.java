package ru.blockfinder.util.behavior;

public interface FloatBehavior {

    float get(Behavior<Executor> behavior);

    @FunctionalInterface
    interface Executor {
        float execute();
    }
}
