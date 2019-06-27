package com.thejays.biarmod.objects.assets.blockstate;


import com.thejays.biarmod.BiarMod;

public class Model {

    public String model;

    public Model(String registryName){
        this.model = BiarMod.MODID + ":" + registryName;
    }

}