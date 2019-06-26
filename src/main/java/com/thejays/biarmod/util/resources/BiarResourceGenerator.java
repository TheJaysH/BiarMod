package com.thejays.biarmod.util.resources;

import com.thejays.biarmod.BiarMod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BiarResourceGenerator {

    private static final File optionsFile = new File(BiarMod.MINECRAFT_ROOT, "options.txt");

    public void setDeafultResourcePack(){

        if (!optionsFile.exists()){
            BiarMod.logger.error("Options file is missing - This is either an error or the first run.");
        }

    }

}
