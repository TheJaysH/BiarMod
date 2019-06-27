package com.thejays.biarmod.init;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.config.ConfigHandler;
import com.thejays.biarmod.objects.BiarBase;
import com.thejays.biarmod.objects.assets.BiarBlockModel;
import com.thejays.biarmod.objects.assets.BiarBlockstate;
import com.thejays.biarmod.objects.assets.BiarItemModel;
import com.thejays.biarmod.objects.children.BiarBlockBase;
import com.thejays.biarmod.objects.children.BiarItemBase;
import com.thejays.biarmod.objects.children.BiarTabBase;
import com.thejays.biarmod.util.BiarArchiver;
import com.thejays.biarmod.util.BiarDeserialization;
import com.thejays.biarmod.util.resources.BiarBlockModels;
import com.thejays.biarmod.util.resources.BiarBlockstates;
import com.thejays.biarmod.util.resources.BiarResourceGenerator;

import java.io.File;

/**
 * This class is responsible for parsing the json file, then creating the BiarBase object ({@link BiarBase})
 */
public class BiarInit {

    public static BiarBase biarBase;

    /**
     * //TODO: Update comment
     * This Method will try to Deserialize the json file to {@link BiarBase}
     */
    public static void preInit(){

        if (!ConfigHandler.useJsonOnly){

            extractBiartFiles();

            if (ConfigHandler.compileResources){
                //TODO: compileResources
            }
        }

        deserializeBase();
    }


    /**
     * This Method will try init blocks & items
     */
    public static void init(){

        // Check if biarBase was created, otherwise return.
        if (null == biarBase){
            BiarMod.logger.error("biarBase is null, Refusing to initialize Objects.");
            return;
        }

        BiarMod.logger.info("********************** INITIALIZING OBJECTS **********************");

        // Load the Tabs
        try {
            initTabs();
        } catch (Exception e) {
            BiarMod.logger.error("biart initTabs failed: " + e.getMessage());
        }

        // Load the Blocks
        try {
            initBlocks();
        } catch (Exception e) {
            BiarMod.logger.error("biart initBlocks failed: " + e.getMessage());
        }

        // Load the Items
        try {
            initItems();
        } catch (Exception e) {
            BiarMod.logger.error("biart initItems failed: " + e.getMessage());
        }
    }


    public static void postInit(){

        BiarResourceGenerator.createResources();



    }

    private static void initBlocks(){

        if (biarBase.hasBlocks())
            for (BiarBlockBase block : biarBase.BLOCKS){

            if (!block.hasValues()){
                BiarMod.logger.warn("Refusing to load BLOCK: Missing required values");
                continue;
            }

            BiarMod.logger.info("ADDING BLOCK: " + block.registryName);
            BiarBlocks.addBlock(block);
        }
        else
            BiarMod.logger.warn("No BLOCKS found in biart");

    }

    private static void initItems(){

        if (biarBase.hasItems())
            for (BiarItemBase item : biarBase.ITEMS){

                if (!item.hasValues()){
                    BiarMod.logger.warn("Refusing to load ITEM: Missing required values");
                    continue;
                }

                BiarItems.addItem(item);
            }
        else
            BiarMod.logger.warn("No ITEMS found in biart");

    }

    private static void initTabs(){

        if (biarBase.hasTabs())
            for (BiarTabBase tab : biarBase.TABS){

                if (!tab.hasValues()){
                    BiarMod.logger.warn("Refusing to load TAB: Missing required values");
                    continue;
                }

                BiarTabs.addTab(tab);
            }
        else
            BiarMod.logger.warn("No TABS found in biart");
    }

    private static void deserializeBase(){
        try {
            biarBase = BiarDeserialization.getBiartBase();
        } catch (Exception e) {
            BiarMod.logger.error("biart preInit#getBiartBase failed: " + e.getMessage());
        }
    }

    private static void extractBiartFiles(){

        try {

            File fileZip = new File(BiarMod.BIAR_ROOT, "biarmod.zip");
            File destDir = new File(BiarMod.BIAR_ROOT, "");

            BiarArchiver.unzipBiar(fileZip, destDir);

        } catch (Exception e){

            BiarMod.logger.error("biart preInit#unZip failed: " + e.getMessage());

        }

    }
}
