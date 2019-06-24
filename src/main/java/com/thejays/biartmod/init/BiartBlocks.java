package com.thejays.biartmod.init;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.block.BlockBase;
import com.thejays.biartmod.objects.children.BiartBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BiartBlocks {

    public static List<Block> BLOCKS = new ArrayList<>();

    public static void addBlock(BiartBlockBase block){

        try {
            BLOCKS.add(new BlockBase(Material.ROCK, block.unlocalizedName, block.registryName));
        } catch (Exception e){
            BiartMod.logger.error("Failed to add Block to list - " + e.getMessage());
        }

    }


}
