package com.mrrockis.simplezoom.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mrrockis.simplezoom.CommonClass;
import com.mrrockis.simplezoom.Constants;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @ModifyReturnValue(at = @At("RETURN"),
            method = "getFov(Lnet/minecraft/client/Camera;FZ)F")
    private float getFieldOfView(float original) {
        if (Constants.TOGGLE_KEY.isDown()) {
            return CommonClass.getZoomFieldOfView(original);
        }

        CommonClass.resetZoomLevel();
        return original;
    }
}
