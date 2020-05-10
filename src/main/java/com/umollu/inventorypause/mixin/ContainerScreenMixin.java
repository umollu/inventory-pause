package com.umollu.inventorypause.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.ContainerProvider;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.container.Container;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ContainerScreen.class)
public abstract class ContainerScreenMixin<T extends Container> extends Screen implements ContainerProvider<T> {

    protected ContainerScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "isPauseScreen", at = @At("HEAD"), cancellable = true)
    public void isPauseScreen(CallbackInfoReturnable cir) {

        if((Object)this instanceof AbstractInventoryScreen)
        {
            cir.setReturnValue(true);
            cir.cancel();
        }

    }
}
