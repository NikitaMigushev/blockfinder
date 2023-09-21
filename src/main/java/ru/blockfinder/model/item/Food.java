package ru.blockfinder.model.item;

import org.cloudburstmc.api.player.Player;

public interface Food {

    boolean onEatenBy(Player player);
}
