package com.thejays.biarmod.util;

import com.thejays.biarmod.BiarMod;

import java.io.File;

public class BiarArchiver {

    public static void unzipBiar(File zipFile, File destination){

        BiarMod.logger.info("********************** Extracting " + zipFile.getName() + " **********************");

        try {

            BiarZip.unzip(zipFile.getAbsolutePath(), destination.getAbsolutePath());

        } catch (Exception e){
            BiarMod.logger.error("Failed: " + e.getMessage());
        }


    }

}
