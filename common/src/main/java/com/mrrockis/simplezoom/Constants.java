package com.mrrockis.simplezoom;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

    public static final String MOD_ID = "simplezoom";
    public static final String MOD_NAME = "Simple Zoom";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final KeyMapping.Category KEY_CATEGORY =
            new KeyMapping.Category(Identifier.fromNamespaceAndPath("simplezoom", "main"));

    public static final KeyMapping TOGGLE_KEY = new KeyMapping(
            "key.simplezoom.toggle",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_C,
            KEY_CATEGORY
    );
}