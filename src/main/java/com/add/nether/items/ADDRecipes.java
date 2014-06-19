package com.add.nether.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ADDRecipes {
	public static void registerRecipes(){
		//**Mod oriented**\\
		
		//Items
		GameRegistry.addShapelessRecipe(new ItemStack(Items.potionitem, 1, 0), new Object[]{
			ADDItems.blueBulb, Items.glass_bottle
		});
				
		GameRegistry.addRecipe(new ItemStack(Items.cake, 1), new Object[] {
			"AAA", 
			"BEB", 
			"CCC", 
			'A', Items.milk_bucket, 'B', ADDItems.yellowBulb, 'C', Items.wheat, 'E', Items.egg
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), new Object[] {
			Blocks.pumpkin, ADDItems.yellowBulb, Items.egg
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.fermented_spider_eye), new Object[] {
	    	Items.spider_eye, Blocks.brown_mushroom, ADDItems.yellowBulb
	    });
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.snowball), new Object[]{
			ADDItems.blackBulb, new ItemStack(Items.potionitem, 1, 0)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.ice), new Object[]{
			ADDItems.blackBulb, Items.water_bucket
		});

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian), new Object[]{
			ADDItems.blackBulb, Items.lava_bucket
		});
		
		//**Additions to base game**\\
		GameRegistry.addShapelessRecipe(new ItemStack(Items.water_bucket), new Object[]{
			Items.bucket, new ItemStack(Items.potionitem, 1, 0), new ItemStack(Items.potionitem, 1, 0), new ItemStack(Items.potionitem, 1, 0)
		});
	}
}
