package com.thejays.biarmod.util.resources;

import com.thejays.biarmod.objects.assets.BiarBlockstate;

import java.util.ArrayList;
import java.util.List;

public class BiarBlockstates {

    public static List<BiarBlockstate> blockstates = new ArrayList<>();

    public static void addBlockstate(BiarBlockstate biarBlockstate){

        blockstates.add(biarBlockstate);
    }

}
