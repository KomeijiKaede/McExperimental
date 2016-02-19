package com.github.komeijikaede.mcexperimental;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ExplosionSword extends ItemSword{

	public ExplosionSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase target, EntityLivingBase owner) {
		boolean b = super.hitEntity(p_77644_1_, target, owner);

//		p_77644_2_.motionY = 3f;
		target.worldObj.createExplosion(
				owner,
				target.posX,
				target.posY,
				target.posZ,
				40F,
				false
		);
		return b;
	}

}
