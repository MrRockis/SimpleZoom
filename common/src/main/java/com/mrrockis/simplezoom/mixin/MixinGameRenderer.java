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
    @Inject(method = "getFov(Lnet/minecraft/client/Camera;FZ)F",
            at = @At(value = "RETURN", ordinal = 1),
            cancellable = true
    )
    private void getFieldOfView(Camera camera, float tickDelta, boolean changingFov,
                                CallbackInfoReturnable<Float> cir) {
        if (Constants.TOGGLE_KEY.isDown()) {
            cir.setReturnValue(CommonClass.getZoomFieldOfView(cir.getReturnValueF()));
        } else {
            CommonClass.resetZoomLevel();
        }
    }
}
