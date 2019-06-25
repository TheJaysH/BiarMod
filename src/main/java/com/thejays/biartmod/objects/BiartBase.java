package com.thejays.biartmod.objects;

import com.thejays.biartmod.objects.children.BiartBlockBase;
import com.thejays.biartmod.objects.children.BiartItemBase;
import com.thejays.biartmod.objects.children.BiartTabBase;

public class BiartBase {

    public BiartTabBase[] TABS;
    public BiartBlockBase[] BLOCKS;
    public BiartItemBase[] ITEMS;

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
