package com.github.komeijikaede.mcexperimental;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class SampleBlock extends BlockDirectional
{
   @SideOnly(Side.CLIENT)
   private IIcon TopIcon;

   @SideOnly(Side.CLIENT)
   private IIcon SideIcon;

   public SampleBlock() {
       super(Material.rock);
       setCreativeTab(CreativeTabs.tabBlock);
       setBlockName("Null");
       setBlockTextureName("samplemod:block_sample");
       setHardness(1.5F);
       setResistance(1.0F);
       setStepSound(Block.soundTypeStone);
       setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public int quantityDropped(int meta, int fortune, Random random){
       //ドロップするアイテムを返す
       return quantityDroppedWithBonus(fortune, random);
   }

   @Override
   public int quantityDropped(Random random){
       //ドロップさせる量を返す
       return 1;
   }

   @Override
   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister)
   {
       this.TopIcon = par1IconRegister.registerIcon("samplemod:block_sample");
       this.SideIcon = par1IconRegister.registerIcon("samplemod:block_sample_side");
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int par1, int par2)
   {
        if(par1 == 0 || par1 == 1)
        {
                 return TopIcon;
        }
        else
        {
                 return SideIcon;
        }
   }

   @Override
	public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
//	   BlockAdded line = new BlockAdded(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_);
//	   line.world.setBlock(line.x+1, line.y, line.z, SampleBlockCore.blockSample);
//	   line.world.setBlock(line.x-1, line.y, line.z, SampleBlockCore.blockSample);
//	   line.world.setBlock(line.x, line.y, line.z+1, SampleBlockCore.blockSample);
//	   line.world.setBlock(line.x, line.y, line.z-1, SampleBlockCore.blockSample);

	   SampleBlockCore.queue.add(new BlockAdded(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_));
		return super.onBlockPlaced(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
	}


   @Override
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
//	   while(p_149726_3_<256)
//	   p_149726_1_.setBlock(p_149726_2_, ++p_149726_3_, p_149726_4_, SampleBlockCore.blockSample);
   }

  private int start;

  public void setStart(int i) {
	  this.start = i;
  }

    @Override
    	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
    	if (start>1000*3)
    		return;
    	world.setBlock(x+1, y, z, SampleBlockCore.blockSample);
    	world.setBlock(x, y+1, z, Blocks.tnt);
    	world.setBlock(x, y, z+1, SampleBlockCore.blockSample);
    	start++;
    }

   public static class BlockAdded {
	   public final World world;
	   public final int x;
	   public final int y;
	   public final int z;

	   public BlockAdded(World world, int x, int y, int z) {
		   this.world = world;
		   this.x = x;
		   this.y = y;
		   this.z = z;
	   }

	   public List<BlockAdded> w() {
		   ArrayList<BlockAdded> list = Lists.newArrayList();
		   list.add(new BlockAdded(this.world, this.x+1, this.y, this.z));
		   list.add(new BlockAdded(this.world, this.x-1, this.y, this.z));
		   list.add(new BlockAdded(this.world, this.x, this.y, this.z+1));
		   list.add(new BlockAdded(this.world, this.x, this.y, this.z-1));
		   return list;
	   }
   }
}