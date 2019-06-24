package com.thejays.biartmod.block;

import com.thejays.biartmod.BiartMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

    public BlockBase(Material material, String unlocalizedName, String registryName) {
        this(material, SoundType.STONE, unlocalizedName, registryName);
    }

    public BlockBase(Material material, SoundType sound, String unlocalizedName, String registryName) {
        super(material);
        setUnlocalizedName(BiartMod.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setSoundType(sound);
    }

}
