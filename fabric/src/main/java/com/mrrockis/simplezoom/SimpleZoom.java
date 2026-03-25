package com.mrrockis.simplezoom;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;

public class SimpleZoom implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyMappingHelper.registerKeyMapping(Constants.TOGGLE_KEY);
        Constants.LOG.info("Registered Keybinds for " + Constants.MOD_ID);
    }
}
