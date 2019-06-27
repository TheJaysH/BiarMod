package com.thejays.biarmod.util.resources;

import com.thejays.biarmod.objects.assets.BiarBlockModel;
import com.thejays.biarmod.objects.assets.BiarItemModel;

import java.util.ArrayList;
import java.util.List;

public class BiarItemModels {


    public static List<BiarItemModel> itemModels = new ArrayList<>();

    public static void addModel(BiarItemModel model){
        itemModels.add(model);
    }


}
