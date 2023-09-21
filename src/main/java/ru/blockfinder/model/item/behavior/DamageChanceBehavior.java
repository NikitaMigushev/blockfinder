package ru.blockfinder.model.item.behavior;

import ru.blockfinder.util.behavior.Behavior;

public interface DamageChanceBehavior {

    int getDamageChance(Behavior<Executor> executor, int unbreaking);

    interface Executor {

        int execute(int unbreaking);
    }
}
