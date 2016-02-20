package com.kamesuta.mc.experimentalmod;

import com.kamesuta.mc.experimentalmod.nullblocks.NullBlock;
import com.kamesuta.mc.experimentalmod.nullblocks.NullBlockFence;
import com.kamesuta.mc.experimentalmod.nullblocks.NullBlockLadder;
import com.kamesuta.mc.experimentalmod.nullblocks.NullBlockPane;
import com.kamesuta.mc.experimentalmod.nullblocks.NullBlockSlab;
import com.kamesuta.mc.experimentalmod.nullblocks.NullBlockStair;
import com.kamesuta.mc.experimentalmod.nullblocks.NullBlockTorch;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class McExperimentalMod {
	@Instance(Reference.MODID)
	public static McExperimentalMod instance;

	//SUSHI

	// 追加するブロックの定義
	/* public static Block * ; */
	public static Block BlockNull;
	public static Block BlockNullStair;
	public static Block BlockNullSlab;
	public static Block BlockNullFence;
	public static Block BlockNullPane;
	public static Block BlockNullLadder;
	public static Block BlockNullTorch;

	// レンダーIDの取得
	public static int RenderID;

	@EventHandler
	public void perInit(FMLPreInitializationEvent event) {
		Material m = Material.craftedSnow;

		BlockNull = new NullBlock(m)
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockName("blockNull")
		.setBlockTextureName(Reference.MODID + ":wool_null");

		BlockNullStair = new NullBlockStair(BlockNull, 0)
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockName("blockNullStair")
		.setBlockTextureName(Reference.MODID + ":wool_null");

		BlockNullSlab = new NullBlockSlab(false, m)
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockName("blockNullSlab")
		.setBlockTextureName(Reference.MODID + ":wool_null");

		BlockNullFence = new NullBlockFence(Reference.MODID + ":wool_null", m)
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockName("blockNullFence");

		BlockNullPane = new NullBlockPane(Reference.MODID + ":wool_null", Reference.MODID + ":wool_null", m, false)
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockName("blockNullPane");

		BlockNullLadder = new NullBlockLadder()
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockName("blockNullLadder")
		.setBlockTextureName(Reference.MODID + ":wool_null");

		BlockNullTorch = new NullBlockTorch()
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockName("blockNullTorch")
		.setBlockTextureName(Reference.MODID + ":wool_null")
		.setLightOpacity(15)
		.setLightLevel(15);

		GameRegistry.registerBlock(BlockNull, "BlockNull");
		GameRegistry.registerBlock(BlockNullStair, "BlockNullStair");
		GameRegistry.registerBlock(BlockNullSlab, "BlockNullSlab");
		GameRegistry.registerBlock(BlockNullFence, "BlockNullFence");
		GameRegistry.registerBlock(BlockNullPane, "BlockNullPane");
		GameRegistry.registerBlock(BlockNullLadder, "BlockNullLadder");
		GameRegistry.registerBlock(BlockNullTorch, "BlockNullTorch");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

	}
}