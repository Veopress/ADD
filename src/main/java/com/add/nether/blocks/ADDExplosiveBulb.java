package com.add.nether.blocks;

import static net.minecraftforge.common.EnumPlantType.Cave;
import static net.minecraftforge.common.EnumPlantType.Crop;
import static net.minecraftforge.common.EnumPlantType.Desert;
import static net.minecraftforge.common.EnumPlantType.Nether;
import static net.minecraftforge.common.EnumPlantType.Plains;
import static net.minecraftforge.common.EnumPlantType.Water;

import java.util.Random;

import com.add.nether.Explosion;
import com.add.nether.nether;
import com.add.nether.handlers.reference;
import com.add.nether.items.ADDItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class ADDExplosiveBulb extends BlockBush {
	public ADDExplosiveBulb(){
		super();
		setBlockName("explosiveBulb");
		setBlockTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
		setLightLevel(0.25F);
		setCreativeTab(nether.ADDNetherTab);
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {  
        return Nether;
    }
	
	@Override
	/**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == Blocks.netherrack || p_149854_1_ == Blocks.soul_sand;
    }
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return null;
	}
	
	public int quantityDropped(Random p_149745_1_) {
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_){
		return ADDItems.redBulb;
	}
	
	/**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
        if (p_149670_5_ instanceof EntityLivingBase && !p_149670_1_.isRemote)
        {
        	Explosion explode = new Explosion(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_);
        	p_149670_1_.playSoundAtEntity(explode, "game.tnt.primed", 1.0F, 1.0F);
        }
    }
}
