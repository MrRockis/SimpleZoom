package com.mrrockis.simplezoom;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod(Constants.MOD_ID)
public class SimpleZoom {
    public SimpleZoom(IEventBus eventBus, Dist dist) {
        if (dist.isClient()) {
            eventBus.addListener(this::onRegisterKeybinds);
        }
    }

    private void onRegisterKeybinds(RegisterKeyMappingsEvent event) {
        event.register(Constants.TOGGLE_KEY);
        Constants.LOG.info("Registered Keybinds for " + Constants.MOD_ID);
    }
}