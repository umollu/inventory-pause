package com.umollu.inventorypause;

import com.umollu.inventorypause.utils.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class InventoryPauseMod implements ModInitializer {
	public static ModConfig MOD_CONFIG = new ModConfig();

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		MOD_CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
	}
}
