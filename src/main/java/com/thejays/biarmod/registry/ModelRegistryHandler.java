package com.thejays.biarmod.registry;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.init.BiarBlocks;
import com.thejays.biarmod.init.BiarItems;
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

        registerItems();
        registerBlocks();

    }

    public static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    private static void registerItems(){
        try {

            if (BiarItems.ITEMS.size() > 0)
                for (Item item : BiarItems.ITEMS){
                    registerModel(item);
                }
            else
                BiarMod.logger.warn("No ITEMS found in biart");

        } catch (Exception e){

            BiarMod.logger.error("Failed to register Models - " + e.getMessage());

        }
    }

    private static void registerBlocks(){
        try {

            if (BiarBlocks.BLOCKS.size() > 0)
                for (Block block : BiarBlocks.BLOCKS){
                    ModelRegistryHandler.registerModel(Item.getItemFromBlock(block));
                }
            else
                BiarMod.logger.warn("No BLOCK_MODELS found in biart");

        } catch (Exception e){

            BiarMod.logger.error("Failed to register Models - " + e.getMessage());

        }
    }
}
