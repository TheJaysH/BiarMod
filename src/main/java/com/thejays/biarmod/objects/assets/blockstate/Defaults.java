package com.thejays.biarmod.objects.assets.blockstate;

import com.thejays.biarmod.BiarMod;

public class Defaults {

    public String model;

    public Defaults(String registryName) {
        this.model = BiarMod.MODID +  ":" + registryName;
    }

}
