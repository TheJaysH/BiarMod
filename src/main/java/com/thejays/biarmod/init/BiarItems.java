package com.thejays.biarmod.init;

import com.thejays.biarmod.BiarMod;
import com.thejays.biarmod.item.ItemBase;
import com.thejays.biarmod.objects.children.BiarItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BiarItems {

    public static List<Item> ITEMS = new ArrayList<>();

    public static void addItem(BiarItemBase itemIn){

        BiarMod.logger.info("ADDING ITEM: " + itemIn.registryName );

        try {

            Item item = new ItemBase(itemIn.unlocalizedName, itemIn.registryName);

            if (itemIn.hasTabIndex() && BiarInit.biarBase.hasTabs())
                item.setCreativeTab(BiarMod.CREATIVE_TABS.get(itemIn.tabIndex));

            if (itemIn.hasMaxStackSize())
                item.setMaxStackSize(itemIn.maxStackSize);

            ITEMS.add(item);

        } catch ( Exception e){

            BiarMod.logger.error("Failed to add Item to list - " + e.getMessage());

        }

    }

}
