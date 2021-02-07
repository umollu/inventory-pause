package com.umollu.inventorypause.utils;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

import java.util.ArrayList;
import java.util.List;

@Config(name = "inventorypause")
public class ModConfig implements ConfigData {
    boolean pauseInventory = true;
    boolean pauseFurnace = false;
    boolean pauseCraftingTable = false;
    boolean pauseShulkerBox = false;
    List<String> customScreens = new ArrayList<>();

    public boolean debug = false;
}
