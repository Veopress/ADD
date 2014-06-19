package com.add.nether.items;

import com.add.nether.handlers.RegisterHelper;

import net.minecraft.item.Item;

public class ADDItems {
	
	public static Item blueBulb;
	public static Item yellowBulb;
	public static Item redBulb;
	public static Item blackBulb;
	
	public static void registerADDItems(){
		blueBulb = new ADDBlueBulb();
		yellowBulb = new ADDYellowBulb();
		redBulb =new ADDRedBulb();
		blackBulb = new ADDBlackBulb();
		
		RegisterHelper.registerItem(blueBulb);
		RegisterHelper.registerItem(yellowBulb);
		RegisterHelper.registerItem(redBulb);
		RegisterHelper.registerItem(blackBulb);
	}
}
