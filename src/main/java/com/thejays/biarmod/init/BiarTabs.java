package com.thejays.biarmod.init;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.objects.children.BiarTabBase;
import com.thejays.biarmod.tab.TabBase;

public class BiarTabs {

    //TODO: Sanitise
    public  static void addTab(BiarTabBase tabIn){

        BiarMod.logger.info("ADDING TAB: " + tabIn.unlocalizedName);

        BiarMod.CREATIVE_TABS.add(new TabBase(tabIn.unlocalizedName));
    }
}
