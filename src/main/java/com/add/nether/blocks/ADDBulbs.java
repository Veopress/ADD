package com.add.nether.blocks;

import static net.minecraftforge.common.EnumPlantType.Nether;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

import com.add.nether.nether;
import com.add.nether.handlers.reference;
import com.add.nether.items.ADDItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ADDBulbs extends BlockBush {
	@SideOnly(Side.CLIENT)
	private IIcon[] field_149883_a;
	private static final String __OBFID = "CL_00000274";

	protected ADDBulbs() {
		super();
		setBlockName("bulb");
		setBlockTextureName(reference.MODID + ":"
				+ getUnlocalizedName().substring(5));
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
		setLightLevel(0.125F);
		setCreativeTab(nether.ADDNetherTab);
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	}
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return Nether;
    }

	/**
	 * Can this block stay at this position. Similar to canPlaceBlockAt except
	 * gets checked often with plants.
	 */
	public boolean canBlockStay(World p_149718_1_, int p_149718_2_,
			int p_149718_3_, int p_149718_4_) {
		return super.canBlockStay(p_149718_1_, p_149718_2_, p_149718_3_,
				p_149718_4_);
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return 6;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return null;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random p_149745_1_) {
		return 0;
	}

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public Block getBlock(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return ADDBlocks.bulb;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int count = 1;

		if (metadata >= 3) {
			count = 2 + world.rand.nextInt(3)
					+ (fortune > 0 ? world.rand.nextInt(fortune + 1) : 0);
		}

		for (int i = 0; i < count; i++) {
			if (metadata == 1) {
				ret.add(new ItemStack(ADDBlocks.bulb));
			} else if (metadata == 0) {
				ret.add(new ItemStack(ADDItems.blueBulb));
			} else if (metadata == 2) {
				ret.add(new ItemStack(ADDItems.yellowBulb));
			} else if (metadata == 3) {
				ret.add(new ItemStack(ADDItems.redBulb));
			} else if (metadata == 4) {
				ret.add(new ItemStack(ADDItems.blackBulb));
			}
		}

		return ret;
	}

	@Override
	protected boolean canPlaceBlockOn(Block block) {
		return block == Blocks.netherrack || block == Blocks.soul_sand;
	}

	@Override
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_,
			int p_149674_4_, Random p_149674_5_) {
		int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_,
				p_149674_4_);

		if (l < 2 && p_149674_5_.nextInt(8) == 0) {
			++l;
			p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_,
					p_149674_4_, l, 2);
		} else if (l == 2 && p_149674_5_.nextInt(2) == 0) {
			l = (p_149674_5_.nextInt(4) + 3);
			p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_,
					p_149674_4_, l, 2);
		}

		super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_,
				p_149674_5_);
	}

	/**
	 * Drops the block items with a specified chance of dropping the specified
	 * items
	 */
	@Override
	public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_,
			int p_149690_3_, int p_149690_4_, int p_149690_5_,
			float p_149690_6_, int p_149690_7_) {
		if (true && !p_149690_1_.isRemote) {
			int j1 = 1;

			if (p_149690_5_ >= 2) {
				j1 = 2 + p_149690_1_.rand.nextInt(3);

				if (p_149690_7_ > 0) {
					j1 += p_149690_1_.rand.nextInt(p_149690_7_ + 1);
				}
			}

			for (int k1 = 0; k1 < j1; ++k1) {
				if (p_149690_5_ == 3) {
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDItems.blueBulb));
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDBlocks.bulb));
				} else if (p_149690_5_ == 4) {
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDItems.yellowBulb));
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDBlocks.bulb));
				} else if (p_149690_5_ == 5) {
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDItems.redBulb));
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDBlocks.bulb));
				} else if (p_149690_5_ == 6) {
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDItems.blackBulb));
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDBlocks.bulb));
				} else {
					this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_,
							p_149690_4_, new ItemStack(ADDBlocks.bulb));
				}
			}
		}
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_2_ >= 6 ? this.field_149883_a[6]
				: (p_149691_2_ >= 5 ? this.field_149883_a[5]
						: (p_149691_2_ >= 4 ? this.field_149883_a[4]
								: (p_149691_2_ >= 3 ? this.field_149883_a[3]
										: (p_149691_2_ >= 2 ? this.field_149883_a[2]
												: (p_149691_2_ > 0 ? this.field_149883_a[1]
														: this.field_149883_a[0])))));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.field_149883_a = new IIcon[7];

		for (int i = 0; i < this.field_149883_a.length; ++i) {
			this.field_149883_a[i] = p_149651_1_.registerIcon(this
					.getTextureName() + "_stage_" + i);
		}
	}
}
