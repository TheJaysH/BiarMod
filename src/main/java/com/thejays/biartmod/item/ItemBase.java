package com.thejays.biartmod.item;

import com.thejays.biartmod.BiartMod;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String unlocalizedName, String registryName) {
        setUnlocalizedName(BiartMod.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
//        setCreativeTab(GonjMod.GONJ_TAB);
    }

}
