package com.kamesuta.mc.experimentalmod;

<<<<<<< HEAD
=======
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
>>>>>>> refs/remotes/origin/master
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
<<<<<<< HEAD
=======
import net.minecraft.client.settings.KeyBinding;
>>>>>>> refs/remotes/origin/master

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class McExperimentalMod {
	@Instance(Reference.MODID)
	public static McExperimentalMod instance;

	// レンダーIDの取得
	public static int RenderID;

	@EventHandler
<<<<<<< HEAD
	public void perInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
=======
	public void perInit(final FMLPreInitializationEvent event) {
		for (final KeyBinding keyBinding : InputHandler.KEY_BINDINGS) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(InputHandler.INSTANCE);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void serverStarting(final FMLServerStartingEvent event) {
>>>>>>> refs/remotes/origin/master

	}
}

/*public class McExperimentalMod {
	@Instance(Reference.MODID)
	public static McExperimentalMod instance;

	//SUSHI

	// 追加するブロックの定義
	 public static Block * ;
	public static Block BlockNull;
	public static Block BlockNullStair;
	public static Block BlockNullSlab;
	public static Block BlockNullFence;
	public static Block BlockNullPane;
	public static Block BlockNullLadder;
	public static Block BlockNullTorch;
	public static Block FluidNull;

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

		FluidNull = new NullFluidFlowing()
		.setBlockName("fluidNull")
		.setBlockTextureName(Reference.MODID + ":wool_null")
		.setHardness(100f)
		.setLightOpacity(3)
		.setCreativeTab(CreativeTabs.tabBlock);

		GameRegistry.registerBlock(BlockNull, "BlockNull");
		GameRegistry.registerBlock(BlockNullStair, "BlockNullStair");
		GameRegistry.registerBlock(BlockNullSlab, "BlockNullSlab");
		GameRegistry.registerBlock(BlockNullFence, "BlockNullFence");
		GameRegistry.registerBlock(BlockNullPane, "BlockNullPane");
		GameRegistry.registerBlock(BlockNullLadder, "BlockNullLadder");
		GameRegistry.registerBlock(BlockNullTorch, "BlockNullTorch");
		GameRegistry.registerBlock(FluidNull, "FluidNull");
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
}*/