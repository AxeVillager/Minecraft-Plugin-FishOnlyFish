package com.axevillager.fishonlyfish.listeners;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

/**
 * FishingHandler created by Axe_Villager on 2018/05/20.
 */

public class FishingHandler implements Listener {

    @EventHandler
    public void onFish(final PlayerFishEvent event) {
        final PlayerFishEvent.State state = event.getState();
        if (!state.equals(PlayerFishEvent.State.CAUGHT_FISH)) {
            return;
        }
        final Entity entityCaught = event.getCaught();
        if (!isFish(entityCaught)) {
            playUnsuccessfulSounds(event.getHook().getLocation());
            event.setCancelled(true);
        }
    }

    private boolean isFish(final Entity entity) {
        return entity.getName().toLowerCase().contains("fish.");
    }

    private void playUnsuccessfulSounds(final Location location) {
        final World world = location.getWorld();
        world.playSound(location, Sound.ENTITY_BAT_TAKEOFF, 4, 1);
        world.playSound(location, Sound.ENTITY_ITEM_PICKUP, 5, 0);
    }
}