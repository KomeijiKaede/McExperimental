package com.kamesuta.mc.experimentalmod.nullblocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class NullBlockSlab extends BlockSlab {

	public NullBlockSlab(boolean p_i45410_1_, Material p_i45410_2_) {
		super(p_i45410_1_, p_i45410_2_);
	}

	@Override
	public String func_150002_b(int p_150002_1_) {
		return "NullSlab:" + String.valueOf(p_150002_1_);
	}
}
