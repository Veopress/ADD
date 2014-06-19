package com.add.nether.items;

import com.add.nether.nether;
import com.add.nether.blocks.ADDBlocks;
import com.add.nether.handlers.reference;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ADDRedBulb extends ItemSeeds {
	
	private Block field_150925_a;
    /** BlockID of the block the seeds can be planted on. */
    private Block soilBlockID;
    private static final String __OBFID = "CL_00000061";
    
	public ADDRedBulb(){
		super(ADDBlocks.explosiveBulb, Blocks.soul_sand);
		setUnlocalizedName("redBulb");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(nether.ADDNetherTab);
		this.field_150925_a = ADDBlocks.explosiveBulb;
		this.soilBlockID = Blocks.netherrack;
	}
	
	@Override
	/**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
        {
            if ((par3World.getBlock(par4, par5, par6) == Blocks.netherrack || par3World.getBlock(par4, par5, par6) == Blocks.soul_sand) && par3World.isAirBlock(par4, par5 + 1, par6))
            {
                par3World.setBlock(par4, par5 + 1, par6, this.field_150925_a);
                --par1ItemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
