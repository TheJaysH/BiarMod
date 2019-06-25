package com.thejays.biarmod.objects;

import com.thejays.biarmod.objects.children.BiarBlockBase;
import com.thejays.biarmod.objects.children.BiarItemBase;
import com.thejays.biarmod.objects.children.BiarTabBase;

public class BiarBase {

    public BiarTabBase[] TABS;
    public BiarBlockBase[] BLOCKS;
    public BiarItemBase[] ITEMS;

    public boolean hasTabs(){
        return (null != this.TABS && this.TABS.length > 0);
    }

    public boolean hasBlocks(){
        return (null != this.BLOCKS && this.BLOCKS.length > 0);
    }

    public boolean hasItems(){
        return (null != this.ITEMS && this.ITEMS.length > 0);
    }
}
