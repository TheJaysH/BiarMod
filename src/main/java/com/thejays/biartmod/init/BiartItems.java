package com.thejays.biartmod.init;

import com.thejays.biartmod.BiartMod;
import com.thejays.biartmod.item.ItemBase;
import com.thejays.biartmod.objects.children.BiartItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BiartItems {

    public static List<Item> ITEMS = new ArrayList<>();

    public static void addItem(BiartItemBase itemIn){

        try {

            Item item = new ItemBase(itemIn.unlocalizedName, itemIn.registryName);

            if (itemIn.hasTabIndex() && BiartInit.biartBase.hasTabs())
                item.setCreativeTab(BiartMod.CREATIVE_TABS.get(itemIn.tabIndex));

            if (itemIn.hasMaxStackSize())
                item.setMaxStackSize(itemIn.maxStackSize);

            ITEMS.add(item);

        } catch ( Exception e){

            BiartMod.logger.error("Failed to add Item to list - " + e.getMessage());

        }

    }

}
