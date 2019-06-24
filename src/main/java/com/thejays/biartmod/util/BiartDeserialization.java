package com.thejays.biartmod.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.objects.BiartBase;
import net.minecraft.client.Minecraft;

import java.io.File;
import java.nio.file.Files;

public class BiartDeserialization {

    private static final File BIART_ROOT = new File(Minecraft.getMinecraft().mcDataDir, BiartMod.MODID);
    private static final Gson GSON =  new GsonBuilder().create();

    public static BiartBase getBiartBase(){

        BiartBase biartBase = null;
        File file = new File(BIART_ROOT, "biart.json");

        try {

            if (!file.exists()) {
                throw new Exception("Failed to load biart.json: File not found (" + file.getAbsolutePath() +")");
            }

            String json = getJsonString(file);
            biartBase = getBiartBaseFromJson(json);

        } catch (Exception e){

            BiartMod.logger.error("Failed to load biart.json: " + e.getMessage());

        }

        return biartBase;
    }

    private static BiartBase getBiartBaseFromJson(String json){

        BiartBase biartBase = null;

        try {

            biartBase = GSON.fromJson(json, BiartBase.class);

        } catch (Exception e){

            BiartMod.logger.error("Failed to deserialize json: " + e.getMessage());
        }

        return biartBase;
    }

    private static String getJsonString(File file){

        String json = null;

        try {

            json = new String(Files.readAllBytes(file.getAbsoluteFile().toPath()));

        } catch (Exception e){

            BiartMod.logger.error("Failed load json text from biart.json: " + e.getMessage());

        }

         return json;
    }
}
