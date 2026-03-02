package com.mrrockis.simplezoom;

import net.minecraft.util.Mth;

public class CommonClass {
    private static double zoomLevel;

    public static double getZoomLevel() {
        return zoomLevel;
    }

    public static double getDefaultZoomLevel() {
        return 3;
    }

    public static void resetZoomLevel() {
        zoomLevel = getDefaultZoomLevel();
    }

    public static void handleMouseScroll(double delta) {
        if (!Constants.TOGGLE_KEY.isDown())
            return;

        if (delta > 0)
            zoomLevel *= 1.1;
        else if (delta < 0)
            zoomLevel *= 0.9;

        zoomLevel = Mth.clamp(zoomLevel, 1, 50);
    }

    public static float getZoomFieldOfView(float fov) {
        return (float) (fov / getZoomLevel());
    }
}