package com.thejays.biarmod.objects.assets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.objects.assets.blockmodel.Textures;

public class BiarBlockModel {

    public String parent;
    public Textures textures;

    public BiarBlockModel(String namespace, String assetName){
        this.parent = "block/cube_all";
        this.textures = new Textures(namespace, assetName);
    }

    public String toJson(){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        return gson.toJson(this);
    }
}
