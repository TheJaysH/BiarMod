package com.thejays.biarmod.objects.children;

import com.thejays.biarmod.objects.BiarObject;

public class BiarItemBase extends BiarObject {

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
