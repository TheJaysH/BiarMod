package com.thejays.biartmod.config;

import com.thejays.biartmod.BiartMod;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

@Config(modid = BiartMod.MODID)
public class ConfigHandler {

    @Config.Comment("Will check for biartmod.zip then extract & compile the resources *RESTART REQUIRED")
    public static boolean compileResources = true;

    public static final Blocks blocks = new Blocks();
    public static final Items items = new Items();

    public static class Blocks {

        @Config.Comment("The default block hardness")
        public float hardness = 1.5f;

        @Config.Comment("The default block sound")
        public String soundType = "STONE";

        @Config.Comment("The default block material")
        public String materialType = "BRICK";

    }

    public static class Items {

        @Config.Comment("The default item stack size")
        public int maxStackSize = 64;
    }

    @Mod.EventBusSubscriber(modid = BiartMod.MODID)
    private static class EventHandler {
        /**
         * Inject the new values and save to the config file when the config has been changed from the GUI.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(BiartMod.MODID)) {
                ConfigManager.sync(BiartMod.MODID, Config.Type.INSTANCE);
            }
        }
    }

}
