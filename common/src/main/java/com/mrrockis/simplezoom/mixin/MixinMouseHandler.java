package com.mrrockis.simplezoom.mixin;

import com.mrrockis.simplezoom.CommonClass;
import com.mrrockis.simplezoom.Constants;
import net.minecraft.client.MouseHandler;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MixinMouseHandler {
    @Shadow
    private double accumulatedDX;
    @Shadow
    private double accumulatedDY;

    @Inject(at = @At("RETURN"), method = "onScroll(JDD)V")
    private void onMouseScroll(long window, double horizontal,
                               double vertical, CallbackInfo ci) {
        CommonClass.handleMouseScroll(vertical);
    }

    @Inject(method = "turnPlayer()V", at = @At("HEAD"))
    private void applyZoomSensitivity(CallbackInfo ci) {
        if (Constants.TOGGLE_KEY.isDown()) {
            this.accumulatedDX /= CommonClass.getZoomLevel();
            this.accumulatedDY /= CommonClass.getZoomLevel();
        }
    }

    @Redirect(method = "onScroll(JDD)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Inventory;swapPaint(D)V"
            )
    )
    private void canScrollInventory(Inventory inventory, double direction) {
        if (!Constants.TOGGLE_KEY.isDown()) {
            inventory.swapPaint(direction);
        }
    }
}
