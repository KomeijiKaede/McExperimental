package com.kamesuta.mc.experimentalmod.nullblocks;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;

public class NullFluidFlowing extends BlockLiquid {
	public NullFluidFlowing() {
//		super((new MaterialLiquid(MapColor.waterColor) {{this.setNoPushMobility();}}));
		super(Material.water);
	}
}