package com.thejays.biartmod.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabBase extends CreativeTabs {

    public ItemStack tabIcon = new ItemStack(Blocks.DIRT);

    public TabBase(String label) {
        super(label);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return tabIcon;
    }

}
