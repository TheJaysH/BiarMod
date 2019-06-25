package com.thejays.biartmod.init;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.init.BiartBlocks;
import com.thejays.biartmod.init.BiartItems;
import com.thejays.biartmod.objects.BiartBase;
import com.thejays.biartmod.objects.children.BiartBlockBase;
import com.thejays.biartmod.objects.children.BiartItemBase;
import com.thejays.biartmod.objects.children.BiartTabBase;
import com.thejays.biartmod.util.BiartDeserialization;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * This class is responsible for parsing the json file, then creating the BiartBase object ({@link com.thejays.biartmod.objects.BiartBase})
 */
public class BiartInit {

    public static BiartBase biartBase;

    /**
     * This Method will try to Deserialize the json file to {@link com.thejays.biartmod.objects.BiartBase}
     */
    public static void preInit(){

        try {
            biartBase = BiartDeserialization.getBiartBase();
        } catch (Exception e) {
            BiartMod.logger.error("biart preInit failed: " + e.getMessage());
        }

    }


    /**
     * This Method will try init blocks & items
     */
    public static void init(){

        // Check if biartBase was created, return otherwise.
        if (null == biartBase){
            BiartMod.logger.error("biartBase is null, Refusing to initialize Objects.");
            return;
        }

        // Load the Tabs
        try {
            initTabs();
        } catch (Exception e) {
            BiartMod.logger.error("biart init failed: " + e.getMessage());
        }

        // Load the Blocks
        try {
            initBlocks();
        } catch (Exception e) {
            BiartMod.logger.error("biart init failed: " + e.getMessage());
        }

        // Load the Items
        try {
            initItems();
        } catch (Exception e) {
            BiartMod.logger.error("biart init failed: " + e.getMessage());
        }

    }


    public static void initBlocks(){

        if (biartBase.BLOCKS.length > 0)
            for (BiartBlockBase block : biartBase.BLOCKS){
                BiartMod.logger.info("ADDING BLOCK: " + block.registryName);
                BiartBlocks.addBlock(block);
            }
        else
            BiartMod.logger.warn("No BLOCKS found in biart");

    }

    private static void initItems(){

        if (biartBase.ITEMS.length > 0)
            for (BiartItemBase item : biartBase.ITEMS){
                BiartMod.logger.info("ADDING ITEM: " + item.registryName );
                BiartItems.addItem(item);
            }
        else
            BiartMod.logger.warn("No ITEMS found in biart");

    }

    private static void initTabs(){

        if (biartBase.TABS.length > 0)
            for (BiartTabBase tab : biartBase.TABS){
                BiartMod.logger.info("TAB: " + tab.langName);
            }
        else
            BiartMod.logger.warn("No TABS found in biart");

    }

}
