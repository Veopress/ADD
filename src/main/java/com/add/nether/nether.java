package com.add.nether;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.add.nether.blocks.ADDBlocks;
import com.add.nether.handlers.reference;
import com.add.nether.items.ADDItems;
import com.add.nether.items.ADDRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = reference.MODID, version = reference.VERSION, name = reference.NAME)
public class nether {
	public static CreativeTabs ADDNetherTab = new CreativeTabs("ADD_Nether"){
		public Item getTabIconItem(){
			return ADDItems.redBulb;
		}
	};
	

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//-*-*-Blocks-*-*-\\
		ADDBlocks.registerBlocks();
		
		//-*-*-Items-*-*-\\
		ADDItems.registerADDItems();
		
		//-*-*-Recipes-*-*-\\
		ADDRecipes.registerRecipes();
	}
}
