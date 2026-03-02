package com.mrrockis.simplezoom.mixin;

import com.mrrockis.simplezoom.CommonClass;
import com.mrrockis.simplezoom.Constants;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "getFov(Lnet/minecraft/client/Camera;FZ)D",
            at = @At(value = "RETURN", ordinal = 1),
            cancellable = true
    )
    private void getFieldOfView(Camera camera, float tickDelta, boolean changingFov,
                                CallbackInfoReturnable<Double> cir) {
        if (Constants.TOGGLE_KEY.isDown()) {
            float original = (float) cir.getReturnValueD();
            cir.setReturnValue((double)CommonClass.getZoomFieldOfView(original));
        } else {
            CommonClass.resetZoomLevel();
        }
    }
}
