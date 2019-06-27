package com.thejays.biarmod.objects.assets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thejays.biarmod.objects.assets.blockstate.Defaults;
import com.thejays.biarmod.objects.assets.blockstate.Variants;
import scala.Int;

public class BiarBlockstate {

    public int forge_marker;
    public Defaults defaults;
    public Variants variants;

    public BiarBlockstate(String registryName){
        this.forge_marker = 1;
        this.defaults = new Defaults(registryName);
        this.variants = new Variants(registryName);
    }

    public String toJson(){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        return gson.toJson(this);
    }
}

