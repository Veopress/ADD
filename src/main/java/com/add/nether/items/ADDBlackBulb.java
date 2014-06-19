package com.add.nether.items;

import com.add.nether.nether;
import com.add.nether.handlers.reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ADDBlackBulb extends Item {
	public ADDBlackBulb(){
		super();
		setUnlocalizedName("blackBulb");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(nether.ADDNetherTab);
	}
}
