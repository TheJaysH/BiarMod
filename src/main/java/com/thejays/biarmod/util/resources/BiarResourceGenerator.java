package com.thejays.biarmod.util.resources;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.init.BiarInit;
import com.thejays.biarmod.objects.assets.BiarBlockModel;
import com.thejays.biarmod.objects.assets.BiarBlockstate;
import com.thejays.biarmod.objects.assets.BiarItemModel;
import com.thejays.biarmod.objects.children.BiarBlockBase;
import com.thejays.biarmod.objects.children.BiarItemBase;
import com.thejays.biarmod.util.BiarZip;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BiarResourceGenerator {

    public static final File RESOURCES_TEMP = new File(BiarMod.BIAR_ROOT, ".resources");

    public static final File ASSETS_DIR = new File(RESOURCES_TEMP, "assets");
    public static final File ASSETS_MOD_DIR = new File(ASSETS_DIR, BiarMod.MODID);
    public static final File ASSETS_MOD_ROOT_FILE = new File(RESOURCES_TEMP, ".mcassetsroot");

    public static final File BLOCKSTATES_DIR = new File(ASSETS_MOD_DIR, "blockstates");

    public static final File LANG_DIR = new File(ASSETS_MOD_DIR, "lang");

    public static final File MODELS_DIR = new File(ASSETS_MOD_DIR, "models");
    public static final File BLOCK_MODELS_DIR = new File(MODELS_DIR, "block");
    public static final File ITEM_MODELS_DIR = new File(MODELS_DIR, "item");

    public static final File TEXTURES_DIR = new File(ASSETS_MOD_DIR, "textures");
    public static final File ITEM_TEXTURES_DIR = new File(TEXTURES_DIR, "items");
    public static final File BLOCK_TEXTURES_DIR = new File(TEXTURES_DIR, "blocks");


    private static final File OPTIONS_FILE = new File(BiarMod.MINECRAFT_ROOT, "options.txt");



    public static void createResources(){

        createDirectories();

        addFiles();

        zipFiles();

    }

    public void setDeafultResourcePack(){

        if (!OPTIONS_FILE.exists()){
            BiarMod.logger.error("Options file is missing - This is either an error or the first run.");
        }

    }

    public static void createDirectories(){

        BiarMod.logger.info("Creating directories...");

        RESOURCES_TEMP.mkdir();

        ASSETS_DIR.mkdir();
        ASSETS_MOD_DIR.mkdir();

        BLOCKSTATES_DIR.mkdir();

        LANG_DIR.mkdir();

        MODELS_DIR.mkdir();
        BLOCK_MODELS_DIR.mkdir();
        ITEM_MODELS_DIR.mkdir();

        TEXTURES_DIR.mkdir();
        ITEM_TEXTURES_DIR.mkdir();
        BLOCK_TEXTURES_DIR.mkdir();

    }

    private static void zipFiles(){
        BiarZip.zipFiles(RESOURCES_TEMP, BiarMod.BIAR_ROOT.getAbsolutePath() + "\\BiarmodResourcePack.zip"  );
    }

    public static void addFiles(){

        for(BiarBlockBase block : BiarInit.biarBase.BLOCKS){

            String jsonName = block.registryName + ".json";

            BiarBlockstate biarBlockstate = new BiarBlockstate(block.registryName);

            BiarBlockModel biarBlockModel = new BiarBlockModel(BiarMod.MODID, "blocks/snow");

            BiarBlockstates.addBlockstate(biarBlockstate);
            BiarBlockModels.addModel(biarBlockModel);

            try {
                FileUtils.writeStringToFile(new File(BLOCKSTATES_DIR, jsonName), biarBlockstate.toJson());
            } catch (Exception e){
                BiarMod.logger.error("Failed to add file: ", e);
            }

            try {
                FileUtils.writeStringToFile(new File(BLOCK_MODELS_DIR, jsonName), biarBlockModel.toJson());
            } catch (Exception e){
                BiarMod.logger.error("Failed to add file: ", e);
            }

        }

        for (BiarItemBase item : BiarInit.biarBase.ITEMS) {

            String jsonName = item.registryName + ".json";

            BiarItemModel biarItemModel = new BiarItemModel("items/apple");

            try {
                FileUtils.writeStringToFile(new File(ITEM_MODELS_DIR, jsonName), biarItemModel.toJson());
            } catch (Exception e){
                BiarMod.logger.error("Failed to add file: ", e);
            }
        }

    }


}
