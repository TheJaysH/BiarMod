package com.thejays.biarmod.item;

import com.thejays.biarmod.BiarMod;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String unlocalizedName, String registryName) {
        setUnlocalizedName(BiarMod.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
//        setCreativeTab(GonjMod.GONJ_TAB);
    }

}
