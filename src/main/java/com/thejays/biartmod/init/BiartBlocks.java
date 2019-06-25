package com.thejays.biartmod.init;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.block.BlockBase;
import com.thejays.biartmod.objects.children.BiartBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BiartBlocks {

    public static List<Block> BLOCKS = new ArrayList<>();

    public static void addBlock(BiartBlockBase blockIn){

        try {

            Material material = (blockIn.hasMaterial()) ? getMaterial(blockIn.material) : Material.ROCK;
            SoundType soundType = (blockIn.hasSoundType()) ? getSoundType(blockIn.soundType) : SoundType.STONE;

            Block block = new BlockBase(material, soundType, blockIn.unlocalizedName, blockIn.registryName);

            if (blockIn.hasHardness())
                block.setHardness(blockIn.hardness);

            if (blockIn.hasTabIndex() && BiartInit.biartBase.hasTabs())
                block.setCreativeTab(BiartMod.CREATIVE_TABS.get(blockIn.tabIndex));

            BLOCKS.add(block);

        } catch (Exception e){
            BiartMod.logger.error("Failed to add Block to list - " + e.toString());
        }

    }

    //TODO: Add values
    private static Material getMaterial(String materialString){
        Material material;
        switch (materialString.toUpperCase()){
            default:
                BiartMod.logger.error("Failed to match materialString: " + materialString + ". Using default instead");
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
                BiartMod.logger.error("Failed to match soundTypeString: " + soundTypeString + ". Using default instead");
                soundType = SoundType.STONE;
                break;
        }
        return soundType;
    }

}
