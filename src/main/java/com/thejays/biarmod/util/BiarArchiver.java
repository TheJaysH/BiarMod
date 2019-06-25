package com.thejays.biarmod.util;

import com.thejays.biarmod.BiarMod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BiarArchiver {

    public static void unZip(File zipFile, File destination){

        BiarMod.logger.info("********************** Extracting " + zipFile.getName() + " **********************");

        try {

            byte[] buffer = new byte[1024];

            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                File newFile = new File(destination, zipEntry.getName());
                FileOutputStream fos = new FileOutputStream(newFile);

                BiarMod.logger.info("EXTRACTING: " + newFile.getName());

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
            BiarMod.logger.error("Failed: " + e.getMessage());
        }


    }

}
