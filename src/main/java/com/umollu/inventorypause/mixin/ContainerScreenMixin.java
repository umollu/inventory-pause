package com.umollu.inventorypause.mixin;

import net.minecraft.client.gui.ContainerProvider;
import net.minecraft.client.gui.ContainerScreen;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.ingame.AbstractPlayerInventoryScreen;
import net.minecraft.container.Container;
import net.minecraft.text.TextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ContainerScreen.class)
public abstract class ContainerScreenMixin<T extends Container> extends Screen implements ContainerProvider<T> {


    protected ContainerScreenMixin(TextComponent textComponent_1) {
        super(textComponent_1);
    }
    @Inject(method = "isPauseScreen", at = @At("HEAD"), cancellable = true)
    public void isPauseScreen(CallbackInfoReturnable cir) {

        if((Object)this instanceof AbstractPlayerInventoryScreen)
        {
            cir.setReturnValue(true);
            cir.cancel();
        }

    }
}
