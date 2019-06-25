package com.thejays.biartmod.objects.children;

import com.thejays.biartmod.objects.BiartObject;

public class BiartItemBase  extends BiartObject {

    public Integer maxStackSize;

    public Integer tabIndex;
    public boolean isTool;

    public boolean hasTabIndex(){
        return (null != this.tabIndex);
    }

    public boolean hasMaxStackSize(){
        return (null != this.maxStackSize);
    }

}
