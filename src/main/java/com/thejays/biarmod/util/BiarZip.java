package com.thejays.biarmod.util;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.util.resources.BiarResourceGenerator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class BiarZip {

    private static List<String> fileList = new ArrayList<>();

    private static final String SOURCE_FOLDER = BiarResourceGenerator.RESOURCES_TEMP.getAbsolutePath();


    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;


    public static void unzip(String zipFilePath, String destDirectory) throws IOException {

        BiarMod.logger.info("Extracting: " + zipFilePath);

        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            BiarMod.logger.info("Creating dir: " + destDirectory);
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                BiarMod.logger.info("Creating dir: " + destDirectory);
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BiarMod.logger.info("Extracting File: " + filePath);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }


    public static void zipFiles(File srcDir, String zipFile){
        try {

            File outputZip = new File(zipFile);
            List listFiles = new ArrayList();

            //Populate all files...iterate through directories/subdirectories...
            //recursively
            System.out.printf("1. Input directory %s has following files:\n",
                    srcDir.getCanonicalPath());
            listFiles(listFiles, srcDir);

            //Create zip output stream to zip files
            ZipOutputStream zipOutputStream = new ZipOutputStream(
                    new FileOutputStream(outputZip));

            //Create zip files by recursively iterating through directories
            //and sub directories....
            System.out.println("\n2. Output Zipped file at location:"+outputZip.getCanonicalPath());
            createZipFile(listFiles, srcDir, zipOutputStream);

        }
        catch (Exception e) {
            BiarMod.logger.error("Error creating zip file: ", e);
        }
    }

    private static void createZipFile(List<File> listFiles, File inputDirectory,
                                      ZipOutputStream zipOutputStream) throws IOException {

        for (File file : listFiles) {
            String filePath = file.getCanonicalPath();
            int lengthDirectoryPath = inputDirectory.getCanonicalPath().length();
            int lengthFilePath = file.getCanonicalPath().length();

            //Get path of files relative to input directory.
            String zipFilePath = filePath.substring(lengthDirectoryPath + 1, lengthFilePath);

            ZipEntry zipEntry = new ZipEntry(zipFilePath);
            zipOutputStream.putNextEntry(zipEntry);

            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) >= 0) {
                zipOutputStream.write(bytes, 0, length);
            }
            zipOutputStream.closeEntry();
            System.out.println("Zipped file:"+filePath);
        }
        zipOutputStream.close();
    }

    //Get list of all files recursively by iterating through sub directories
    private static List listFiles(List listFiles, File inputDirectory)
            throws IOException {

        File[] allFiles = inputDirectory.listFiles();
        for (File file : allFiles) {
            if (file.isDirectory()) {
                listFiles(listFiles, file);
            } else {
                System.out.println(file.getCanonicalPath());
                listFiles.add(file);
            }
        }
        return listFiles;
    }

}
