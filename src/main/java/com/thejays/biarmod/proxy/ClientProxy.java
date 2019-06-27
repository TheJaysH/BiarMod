package com.thejays.biarmod.proxy;

import com.thejays.biarmod.init.BiarInit;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy implements IProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {

        BiarInit.preInit();
        BiarInit.init();
        BiarInit.postInit();

    }

    @Override
    public void init(FMLInitializationEvent event) {



    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {




    }
}
