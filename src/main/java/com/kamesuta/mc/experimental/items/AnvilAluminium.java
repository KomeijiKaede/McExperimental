package com.kamesuta.mc.experimental.items;

import com.kamesuta.mc.experimental.McExperimentalMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class AnvilAluminium extends Block {

	public AnvilAluminium() {
		super(Material.rock);
	}

	/** レンダーIDを返す。 **/
	@Override
	public int getRenderType() {
		return McExperimentalMod.RenderID;
	}

	/** ブロックが透けるか否かを返す。 **/
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_,
			int p_149646_5_) {
		return true;
	}

	/** 通常のブロックでないかを返す。 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	/** ブロックが透明か否かを返す。 */
	public boolean isOpaqueCube() {
		return false;
	}
}
