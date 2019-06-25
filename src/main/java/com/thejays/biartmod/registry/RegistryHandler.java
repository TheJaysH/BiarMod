package com.thejays.biartmod.registry;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.init.BiartBlocks;
import com.thejays.biartmod.init.BiartItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        BiartMod.logger.info("********************** REGISTERING BLOCKS **********************");

        for(Block block : BiartBlocks.BLOCKS){

            BiartMod.logger.info("Registering: " + block.getUnlocalizedName());

            try{

                event.getRegistry().register(block);

            } catch (Exception e){

                BiartMod.logger.error(e.getMessage());

            }
        }

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        BiartMod.logger.info("********************** REGISTERING ITEMS **********************");

        for (Item item : BiartItems.ITEMS){
            BiartMod.logger.info("Registering: " + item.getUnlocalizedName());

            try {
                event.getRegistry().register(item);
            } catch (Exception e){
                BiartMod.logger.error("Failed to register item: " + e.getMessage());
            }

        }

        for(Block block : BiartBlocks.BLOCKS){

            BiartMod.logger.info("Registering: " + block.getUnlocalizedName());

            try{
                event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            } catch (Exception e){
                BiartMod.logger.error(e.getMessage());
            }
        }

    }
}
