package com.thejays.biarmod.objects.assets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thejays.biarmod.objects.assets.itemmodel.Textures;

public class BiarItemModel {

    public String parent;
    public Textures textures;

    public BiarItemModel(String assetName){
        this.parent = "item/generated";
        this.textures = new Textures(assetName);
    }

    public String toJson(){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        return gson.toJson(this);
    }
}
