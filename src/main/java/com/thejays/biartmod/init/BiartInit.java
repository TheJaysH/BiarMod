package com.thejays.biartmod.init;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.init.BiartBlocks;
import com.thejays.biartmod.init.BiartItems;
import com.thejays.biartmod.objects.BiartBase;
import com.thejays.biartmod.objects.children.BiartBlockBase;
import com.thejays.biartmod.objects.children.BiartItemBase;
import com.thejays.biartmod.objects.children.BiartTabBase;
import com.thejays.biartmod.util.BiartArchiver;
import com.thejays.biartmod.util.BiartDeserialization;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.io.File;

/**
 * This class is responsible for parsing the json file, then creating the BiartBase object ({@link com.thejays.biartmod.objects.BiartBase})
 */
public class BiartInit {

    public static BiartBase biartBase;

    /**
     * //TODO: Update comment
     * This Method will try to Deserialize the json file to {@link com.thejays.biartmod.objects.BiartBase}
     */
    public static void preInit(){

        try {

            File fileZip = new File(BiartMod.BIART_ROOT, "biartmod.zip");
            File destDir = new File(BiartMod.BIART_ROOT, "/");

            BiartArchiver.unZip(fileZip, destDir);

        } catch (Exception e){

            BiartMod.logger.error("biart preInit#unZip failed: " + e.getMessage());

        }

        try {
            biartBase = BiartDeserialization.getBiartBase();
        } catch (Exception e) {
            BiartMod.logger.error("biart preInit#getBiartBase failed: " + e.getMessage());
        }

    }


    /**
     * This Method will try init blocks & items
     */
    public static void init(){

        // Check if biartBase was created, otherwise return.
        if (null == biartBase){
            BiartMod.logger.error("biartBase is null, Refusing to initialize Objects.");
            return;
        }

        // Load the Tabs
        try {
            initTabs();
        } catch (Exception e) {
            BiartMod.logger.error("biart initTabs failed: " + e.getMessage());
        }

        // Load the Blocks
        try {
            initBlocks();
        } catch (Exception e) {
            BiartMod.logger.error("biart initBlocks failed: " + e.getMessage());
        }

        // Load the Items
        try {
            initItems();
        } catch (Exception e) {
            BiartMod.logger.error("biart initItems failed: " + e.getMessage());
        }

    }


    private static void initBlocks(){

        if (biartBase.hasBlocks())
            for (BiartBlockBase block : biartBase.BLOCKS){

                if (!block.hasValues()){
                    BiartMod.logger.warn("Refusing to load BLOCK: Missing required values");
                    continue;
                }

                BiartMod.logger.info("ADDING BLOCK: " + block.registryName);
                BiartBlocks.addBlock(block);
            }
        else
            BiartMod.logger.warn("No BLOCKS found in biart");

    }

    private static void initItems(){

        if (biartBase.hasItems())
            for (BiartItemBase item : biartBase.ITEMS){

                if (!item.hasValues()){
                    BiartMod.logger.warn("Refusing to load ITEM: Missing required values");
                    continue;
                }

                BiartMod.logger.info("ADDING ITEM: " + item.registryName );
                BiartItems.addItem(item);
            }
        else
            BiartMod.logger.warn("No ITEMS found in biart");

    }

    private static void initTabs(){

        if (biartBase.hasTabs())
            for (BiartTabBase tab : biartBase.TABS){

                if (!tab.hasValues()){
                    BiartMod.logger.warn("Refusing to load TAB: Missing required values");
                    continue;
                }

                BiartTabs.addTab(tab);

                BiartMod.logger.info("ADDING TAB: " + tab.langName);
            }
        else
            BiartMod.logger.warn("No TABS found in biart");

    }

}
