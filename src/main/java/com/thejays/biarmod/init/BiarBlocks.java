package com.thejays.biarmod.init;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.block.BlockBase;
import com.thejays.biarmod.objects.children.BiarBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BiarBlocks {

    public static List<Block> BLOCKS = new ArrayList<>();

    public static void addBlock(BiarBlockBase blockIn){

        try {

            Material material = (blockIn.hasMaterial()) ? getMaterial(blockIn.material) : Material.ROCK;
            SoundType soundType = (blockIn.hasSoundType()) ? getSoundType(blockIn.soundType) : SoundType.STONE;

            Block block = new BlockBase(material, soundType, blockIn.unlocalizedName, blockIn.registryName);

            if (blockIn.hasHardness())
                block.setHardness(blockIn.hardness);

            if (blockIn.hasTabIndex() && BiarInit.biarBase.hasTabs())
                block.setCreativeTab(BiarMod.CREATIVE_TABS.get(blockIn.tabIndex));

            BLOCKS.add(block);

        } catch (Exception e){
            BiarMod.logger.error("Failed to add Block to list - " + e.toString());
        }

    }

    //TODO: Add values
    private static Material getMaterial(String materialString){
        Material material;
        switch (materialString.toUpperCase()){
            default:
                BiarMod.logger.warn("Failed to match materialString: `" + materialString + "`. Using default instead");
                material = Material.ROCK;
                break;
        }
        return material;
    }

    //TODO: Add values
    private static SoundType getSoundType(String soundTypeString){
        SoundType soundType;
        switch (soundTypeString){
            default:
                BiarMod.logger.warn("Failed to match soundTypeString: `" + soundTypeString + "`. Using default instead");
                soundType = SoundType.STONE;
                break;
        }
        return soundType;
    }

}
