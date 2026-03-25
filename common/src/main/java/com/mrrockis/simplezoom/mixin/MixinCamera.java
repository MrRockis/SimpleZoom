package com.mrrockis.simplezoom.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mrrockis.simplezoom.CommonClass;
import com.mrrockis.simplezoom.Constants;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Camera.class)
public class MixinCamera {
    @ModifyReturnValue(at = @At("RETURN"),
            method = "calculateFov(F)F")
    private float getFieldOfView(float original) {
        if (Constants.TOGGLE_KEY.isDown()) {
            return CommonClass.getZoomFieldOfView(original);
        }

        CommonClass.resetZoomLevel();
        return original;
    }

    @ModifyReturnValue(at = @At("RETURN"),
            method = "calculateHudFov(F)F")
    private float getHudFieldOfView(float original) {
        if (Constants.TOGGLE_KEY.isDown()) {
            return CommonClass.getZoomFieldOfView(original);
        }

        return original;
    }
}