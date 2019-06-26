package com.thejays.biarmod.util.resources;

import java.util.ArrayList;
import java.util.List;

public class BiarLangFile {

    public static List<String> langFile = new ArrayList<>();

    public void addLangEntry(String line){
        langFile.add(line);
    }



}
