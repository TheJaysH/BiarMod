package com.thejays.biartmod.util;

import com.thejays.biartmod.BiartMod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BiartArchiver {

    public static void unZip(File zipFile, File destination){

        BiartMod.logger.info("********************** Extracting " + zipFile.getName() + " **********************");

        try {

            byte[] buffer = new byte[1024];

            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                File newFile = new File(destination, zipEntry.getName());
                FileOutputStream fos = new FileOutputStream(newFile);

                BiartMod.logger.info("EXTRACTING: " + newFile.getName());

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (Exception e){
            BiartMod.logger.error("Failed: " + e.getMessage());
        }


    }

}
