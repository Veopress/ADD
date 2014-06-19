package com.add.nether.blocks;

import com.add.nether.nether;
import com.add.nether.handlers.reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ADDBlockShadeStone extends Block {
	public ADDBlockShadeStone(){
		super(Material.rock);
		setBlockName("shadeStone");
		setBlockTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(nether.ADDNetherTab);
		setStepSound(soundTypePiston);
		setHardness(2.0F);
		setResistance(10.0F);
		setLightLevel(0F);
		setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public float getAmbientOcclusionLightValue()
    {
        return -15F;
    }
}
