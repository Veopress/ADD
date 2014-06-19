package com.add.nether.items;

import com.add.nether.nether;
import com.add.nether.handlers.reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ADDYellowBulb extends ItemFood {
	public ADDYellowBulb(){
		super(4, 0.3F, false);
		setUnlocalizedName("yellowBulb");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(nether.ADDNetherTab);
	}
}
