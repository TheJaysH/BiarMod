package com.thejays.biartmod.init;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.item.ItemBase;
import com.thejays.biartmod.objects.children.BiartItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BiartItems {

    public static List<Item> ITEMS = new ArrayList<>();

    public static void addItem(BiartItemBase item){

        try{

            ITEMS.add(new ItemBase(item.unlocalizedName, item.registryName));

        } catch ( Exception e){

            BiartMod.logger.error("Failed to add Item to list - " + e.getMessage());

        }

    }

}
