package com.thejays.biarmod.objects.assets.blockstate;

public class Variants {

    public Model[] normal;
    public Model[] inventory;

    public Variants(String registryName){
        this.normal = new Model[]{ new Model(registryName) };
        this.inventory = new Model[]{ new Model(registryName) };
    }

}

