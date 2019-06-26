package com.thejays.biarmod.util;

import com.thejays.biarmod.BiarMod;
import scala.reflect.io.Directory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BiarArchiver {

    public static void unzipBiar(File zipFile, File destination){

        BiarMod.logger.info("********************** Extracting " + zipFile.getName() + " **********************");

        try {

            BiarUnzip.unzip(zipFile.getAbsolutePath(), destination.getAbsolutePath());

        } catch (Exception e){
            BiarMod.logger.error("Failed: " + e.getMessage());
        }


    }

}
