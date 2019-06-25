package com.thejays.biarmod;

import com.thejays.biarmod.proxy.ClientProxy;
import com.thejays.biarmod.proxy.IProxy;
import com.thejays.biarmod.proxy.ServerProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Mod(
    modid = BiarMod.MODID,
    name = BiarMod.NAME,
    version = BiarMod.VERSION,
    acceptedMinecraftVersions = BiarMod.MC_VERSION
)
public class BiarMod
{

    public static final String MODID = "biarmod";
    public static final String NAME = "Blocks & Items at Runtime";
    public static final String VERSION = "0.1.1";
    public static final String MC_VERSION = "[1.12.2]";

    public static final File BIAR_ROOT = new File(Minecraft.getMinecraft().mcDataDir, BiarMod.MODID);

    public static Logger logger;

    public static final String CLIENT = "com.thejays.biarmod.proxy.ClientProxy";
    public static final String SERVER = "com.thejays.biarmod.proxy.ServerProxy";

    @SidedProxy(
        clientSide = BiarMod.CLIENT,
        serverSide = BiarMod.SERVER
    )
    public static IProxy proxy;
    public static ClientProxy clientProxy;
    public static ServerProxy serverProxy;

    public static List<CreativeTabs> CREATIVE_TABS = new ArrayList<>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
