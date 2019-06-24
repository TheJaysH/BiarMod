package com.thejays.biartmod.util;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.init.BiartBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ModelRegistryHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

        try {

            if (BiartBlocks.BLOCKS.size() > 0)
                for (Block block : BiartBlocks.BLOCKS){
                    ModelRegistryHandler.registerModel(Item.getItemFromBlock(block));
                }
            else
                BiartMod.logger.warn("No BLOCK_MODELS found in biart");

        } catch (Exception e){

            BiartMod.logger.error("Failed to register Models - " + e.getMessage());

        }
    }

    public static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
