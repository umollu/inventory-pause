package com.umollu.inventorypause.mixin;

import com.umollu.inventorypause.utils.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.gui.screen.ingame.*;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {
    private final ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

    @Inject(method = "isPauseScreen", at = @At("HEAD"), cancellable = true)
    public void isPauseScreen(CallbackInfoReturnable cir) {

        if(isInventory() || isFurnace() || isCraftingTable() || isShulkerBox()) {
            cir.setReturnValue(true);
            cir.cancel();
        } else if(config.debug) {
            System.out.println(this.getClass());
        }
    }

    private boolean isInventory() {
        return config.pauseInventory && (Object)this instanceof AbstractInventoryScreen;
    }

    private boolean isFurnace() {
        return config.pauseFurnace && (Object)this instanceof AbstractFurnaceScreen;
    }

    private boolean isCraftingTable() {
        return config.pauseCraftingTable && (Object)this instanceof CraftingScreen;
    }

    private boolean isShulkerBox() {
        return config.pauseShulkerBox && (Object)this instanceof ShulkerBoxScreen;
    }
}