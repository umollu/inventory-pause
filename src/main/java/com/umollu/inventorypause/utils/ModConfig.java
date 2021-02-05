package com.umollu.inventorypause.utils;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

import java.util.ArrayList;
import java.util.List;

@Config(name = "inventorypause")
public class ModConfig implements ConfigData {
    public boolean pauseInventory = true;
    public boolean pauseFurnace = false;
    public boolean pauseCraftingTable = false;
    public boolean pauseShulkerBox = false;
    public List<String> customScreens = new ArrayList<>();

    public boolean debug = true;
}
