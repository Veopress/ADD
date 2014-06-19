package com.add.nether.blocks;

import net.minecraft.block.Block;

import com.add.nether.handlers.RegisterHelper;

public class ADDBlocks {
	
	public static Block explosiveBulb;
	public static Block shadeStone;
	public static Block bulb;
	
	public static void registerBlocks(){
		//Stones
		shadeStone = new ADDBlockShadeStone();
		
		RegisterHelper.registerBlock(shadeStone);
		
		//Plants;
		bulb = new ADDBulbs();
		
		RegisterHelper.registerBlock(bulb);
		
		explosiveBulb = new ADDExplosiveBulb();
		
		RegisterHelper.registerBlock(explosiveBulb);
	}
}
