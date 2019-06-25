package com.thejays.biartmod.proxy;

import com.thejays.biartmod.init.BiartInit;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy implements IProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {

        BiartInit.preInit();
        BiartInit.init();
//        BiartInit.postInit();

    }

    @Override
    public void init(FMLInitializationEvent event) {



    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {




    }
}
