package com.thejays.biartmod;

import com.thejays.biartmod.proxy.ClientProxy;
import com.thejays.biartmod.proxy.IProxy;
import com.thejays.biartmod.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = BiartMod.MODID,
        name = BiartMod.NAME,
        version = BiartMod.VERSION,
        acceptedMinecraftVersions = BiartMod.MC_VERSION
)
public class BiartMod
{

    public static final String MODID = "biartmod";
    public static final String NAME = "Blocks & Items at Runtime";
    public static final String VERSION = "0.1.1";
    public static final String MC_VERSION = "[1.12.2]";


    public static final String CLIENT = "com.thejays.biartmod.proxy.ClientProxy";
    public static final String SERVER = "com.thejays.biartmod.proxy.ServerProxy";

    @SidedProxy(
            clientSide = BiartMod.CLIENT,
            serverSide = BiartMod.SERVER
    )

    public static Logger logger;

    public static IProxy proxy;
    public static ClientProxy clientProxy;
    public static ServerProxy serverProxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);

    }
}
