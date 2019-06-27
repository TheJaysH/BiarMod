package com.thejays.biarmod.util.resources;

import com.thejays.biarmod.objects.assets.BiarBlockModel;

import java.util.ArrayList;
import java.util.List;

public class BiarBlockModels {


    public static List<BiarBlockModel> blockModels = new ArrayList<>();

    public static void addModel(BiarBlockModel model){
        blockModels.add(model);
    }


}
