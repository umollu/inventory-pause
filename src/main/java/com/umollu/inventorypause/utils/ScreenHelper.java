package com.umollu.inventorypause.utils;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen;

public class ScreenHelper {
    private static final ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

    public static boolean isConfiguredScreen(Object screen) {
        return isInventory(screen) || isFurnace(screen) || isCraftingTable(screen) || isShulkerBox(screen) || isCustomMenu(screen);
    }

    private static boolean isInventory(Object screen) {
        return config.pauseInventory && screen instanceof AbstractInventoryScreen;
    }

    private static boolean isFurnace(Object screen) {
        return config.pauseFurnace && screen instanceof AbstractFurnaceScreen;
    }

    private static boolean isCraftingTable(Object screen) {
        return config.pauseCraftingTable && screen instanceof CraftingScreen;
    }

    private static boolean isShulkerBox(Object screen) {
        return config.pauseShulkerBox && screen instanceof ShulkerBoxScreen;
    }

    private static boolean isCustomMenu(Object screen) {
        for (String s : config.customScreens) {
            if(screen.getClass().getName().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
