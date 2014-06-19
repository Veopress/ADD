package com.add.nether.items;

import com.add.nether.nether;
import com.add.nether.handlers.reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ADDBlueBulb extends Item {
	public ADDBlueBulb(){
		super();
		setUnlocalizedName("blueBulb");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(nether.ADDNetherTab);
	}
}
