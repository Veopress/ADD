package com.add.nether;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Explosion extends Entity{

	public Explosion(World par1World, int X, int Y, int Z) {
		super(par1World);
		explode(par1World, X, Y, Z);
	}
	
	public void explode(World par1,int X, int Y, int Z)
    {
        float f = 2.5F;
        this.worldObj.createExplosion(this, X, Y, Z, f, true);
    }

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}
	
}
