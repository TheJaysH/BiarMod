package com.thejays.biartmod.objects.children;

import com.thejays.biartmod.objects.BiartObject;

import javax.annotation.Nullable;

public class BiartBlockBase extends BiartObject {

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
