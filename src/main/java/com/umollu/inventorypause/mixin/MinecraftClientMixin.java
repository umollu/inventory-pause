package com.umollu.inventorypause.mixin;

import com.umollu.inventorypause.utils.ScreenHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.server.integrated.IntegratedServer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow public abstract SoundManager getSoundManager();
    @Shadow public abstract boolean isIntegratedServerRunning();
    @Shadow private @Nullable IntegratedServer server;

    @Inject(at = @At("TAIL"), method = "openScreen")
    public void openScreen(Screen screen, CallbackInfo ci) {
        if (ScreenHelper.isConfiguredScreen(screen))
        {
            boolean canPauseGame = isIntegratedServerRunning() && !this.server.isRemote();
            if(canPauseGame) {
                this.getSoundManager().pauseAll();
            }
        }
    }
}