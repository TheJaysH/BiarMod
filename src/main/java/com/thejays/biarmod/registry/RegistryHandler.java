package com.thejays.biarmod.registry;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.init.BiarBlocks;
import com.thejays.biarmod.init.BiarInit;
import com.thejays.biarmod.init.BiarItems;
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

        if (null == BiarInit.biarBase){
            BiarMod.logger.warn("No Blocks will be registered");
            return;
        }

        if (BiarInit.biarBase.hasBlocks()){
            BiarMod.logger.info("********************** REGISTERING BLOCKS **********************");

            for(Block block : BiarBlocks.BLOCKS){

                BiarMod.logger.info("Registering: " + block.getUnlocalizedName());

                try{

                    event.getRegistry().register(block);

                } catch (Exception e){

                    BiarMod.logger.error(e.getMessage());

                }
            }
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        if (null == BiarInit.biarBase){
            BiarMod.logger.warn("No Items will be registered");
            return;
        }

        if (BiarInit.biarBase.hasItems()){

            BiarMod.logger.info("********************** REGISTERING ITEMS **********************");

            for (Item item : BiarItems.ITEMS){
                BiarMod.logger.info("Registering: " + item.getUnlocalizedName());

                try {
                    event.getRegistry().register(item);
                } catch (Exception e){
                    BiarMod.logger.error("Failed to register item: " + e.getMessage());
                }

            }
        }

       if (BiarInit.biarBase.hasBlocks()){

           BiarMod.logger.info("********************** REGISTERING ITEM BLOCKS **********************");

           for(Block block : BiarBlocks.BLOCKS){

               BiarMod.logger.info("Registering: " + block.getUnlocalizedName());

               try{
                   event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
               } catch (Exception e){
                   BiarMod.logger.error(e.getMessage());
               }
           }
       }



    }
}
