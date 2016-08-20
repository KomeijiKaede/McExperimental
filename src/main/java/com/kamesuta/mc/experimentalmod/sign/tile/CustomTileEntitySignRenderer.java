package com.kamesuta.mc.experimentalmod.sign.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;

public class CustomTileEntitySignRenderer extends TileEntitySignRenderer
{
	@Override
	public void renderTileEntityAt(final TileEntitySign p_147500_1_, final double p_147500_2_, final double p_147500_4_, final double p_147500_6_, final float p_147500_8_)
	{
		super.renderTileEntityAt(p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
	}

	@Override
	public void renderTileEntityAt(final TileEntity p_147500_1_, final double p_147500_2_, final double p_147500_4_, final double p_147500_6_, final float p_147500_8_)
	{
		this.renderTileEntityAt((TileEntitySign)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
	}
}