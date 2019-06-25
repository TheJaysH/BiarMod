package com.thejays.biarmod.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.objects.BiarBase;

import java.io.File;
import java.nio.file.Files;

public class BiarDeserialization {

    private static final Gson GSON =  new GsonBuilder().create();

    //TODO: This looks a bit messy - must clean it up!
    public static BiarBase getBiartBase(){

        BiarBase biarBase = null;
        File file = new File(BiarMod.BIAR_ROOT, "biar.json");

        try {

            if (!file.exists()) {
                BiarMod.logger.error("Failed to load biart.json: File not found (" + file.getAbsolutePath() +")");
                return null;
            }

            String json = getJsonString(file);
            biarBase = getBiartBaseFromJson(json);

        } catch (Exception e){

            BiarMod.logger.error("Failed to load biart.json: " + e.getMessage());

        }

        return biarBase;
    }

    private static BiarBase getBiartBaseFromJson(String json){

        BiarBase biarBase = null;

        try {

            biarBase = GSON.fromJson(json, BiarBase.class);

        } catch (Exception e){

            BiarMod.logger.error("Failed to deserialize json: " + e.getMessage());
        }

        return biarBase;
    }

    private static String getJsonString(File file){

        String json = null;

        try {

            json = new String(Files.readAllBytes(file.getAbsoluteFile().toPath()));

        } catch (Exception e){

            BiarMod.logger.error("Failed load json text from biart.json: " + e.getMessage());

        }

         return json;
    }
}
