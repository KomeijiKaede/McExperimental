package com.kamesuta.mc.experimentalmod.sign;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBench extends Block
{
	public BlockBench(final int id)
	{
		super(Material.rock);
		setHardness(5.0F);
		setResistance(2000.0F);
		setLightOpacity(0);
		setBlockName("bench");
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	//テクスチャはめんどいのでパス
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(final int par1, final int par2)
	{
		return Blocks.enchanting_table.getIcon(par1, par2);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(final IIconRegister par1IconRegister){}

	//重要。ココでBenchCoreに入っているレンダーのIDを返す
	@Override
	public int getRenderType()
	{
		return BenchCore.blockRenderId;
	}

	//下の２つはとりあえず両方falseに
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	//レンダーで使ったり使わなかったり
	@Override
	public void setBlockBoundsForItemRender()
	{
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	}

	//階段やハーフブロックみるといいかも
	@Override
	public void setBlockBoundsBasedOnState(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4)
	{
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	}

	//当たり判定。サボテンやソウルサンドを参考にすると良い。ココの設定をすると、onEntityCollidedWithBlockが呼ばれるようになる
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int par4)
	{
		final double d = 0.0625D;
		return AxisAlignedBB.getBoundingBox(par2 + d, par3, par4 + d, par2 + 1 - d, par3 + 0.75D - d, par4 + 1 - d);
	}

	//ブロックに視点を合わせた時に出てくる黒い線のアレ
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int par4)
	{
		return AxisAlignedBB.getBoundingBox(par2, par3, par4, par2 + 1, par3 + 0.75D, par4 + 1);
	}
}