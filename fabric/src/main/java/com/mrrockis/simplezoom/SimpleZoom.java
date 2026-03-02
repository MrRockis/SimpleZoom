package com.mrrockis.simplezoom;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class SimpleZoom implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(Constants.TOGGLE_KEY);
        Constants.LOG.info("Registered Keybinds for " + Constants.MOD_ID);
    }
}
