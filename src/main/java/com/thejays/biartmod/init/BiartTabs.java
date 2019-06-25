package com.thejays.biartmod.init;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.objects.children.BiartTabBase;
import com.thejays.biartmod.tab.TabBase;

public class BiartTabs {

    //TODO: Sanitise
    public  static void addTab(BiartTabBase tabIn){

        if (!tabIn.hasValues()){
            return;
        }

        BiartMod.CREATIVE_TABS.add(new TabBase(tabIn.unlocalizedName));

    }
}
