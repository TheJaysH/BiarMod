package com.thejays.biarmod.objects.children;

import com.thejays.biarmod.objects.BiarObject;

public class BiarBlockBase extends BiarObject {

    public Integer tabIndex;
    public Float hardness;
    public String soundType;
    public String material;

    public boolean hasSoundType(){
        return (null != this.soundType);
    }

    public boolean hasMaterial(){
        return (null != this.material);
    }

    public boolean hasTabIndex(){
        return (null != this.tabIndex);
    }

    public boolean hasHardness(){
        return (null != this.hardness);
    }

}
