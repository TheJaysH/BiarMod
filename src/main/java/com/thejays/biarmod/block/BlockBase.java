package com.thejays.biarmod.block;

import com.thejays.biarmod.BiarMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

    public BlockBase(Material material, SoundType soundType, String unlocalizedName, String registryName) {
        super(material);

        setUnlocalizedName(BiarMod.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setSoundType(soundType);
    }



}
