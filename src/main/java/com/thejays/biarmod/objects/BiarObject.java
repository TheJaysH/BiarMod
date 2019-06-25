package com.thejays.biarmod.objects;

/**
 * Base object for Items & Blocks
 * - This is the result from deserializing the json
 */
public abstract class BiarObject {

    public String unlocalizedName;
    public String registryName;
    public String langName;

    public boolean hasValues(){
        return (null != this.unlocalizedName && null != this.registryName && null != this.langName);
    }

}
