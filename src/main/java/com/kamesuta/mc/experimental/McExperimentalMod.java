package com.kamesuta.mc.experimental;

import com.kamesuta.mc.experimental.items.AnvilAluminium;
import com.kamesuta.mc.experimental.items.RenderAnvilAluminium;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class McExperimentalMod {
	@Instance(Reference.MODID)
	public static McExperimentalMod instance;

	// 追加するブロックの定義
	/* public static Block * ; */
	public static Block AnvilAluminium;

	// レンダーIDの取得
	public static int RenderID;

	@EventHandler
	public void perInit(FMLPreInitializationEvent event) {

		/* ブロックの実装。詳細割愛。 */
		AnvilAluminium = new AnvilAluminium();

		AnvilAluminium.setCreativeTab(CreativeTabs.tabBlock);

		AnvilAluminium.setBlockName("blockAluminium");

		AnvilAluminium.setBlockTextureName("aluminiummod:aluminium_anvil");

		GameRegistry.registerBlock(AnvilAluminium, "AnvilAluminium");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		/* FMLCommonHandler.instance().getSide() で、クライアントサイドでのみの動作としている。 */
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			/*
			 * レンダーIDの設定。 RenderingRegistry.getNextAvailableRenderId()
			 * で、未使用のレンダーIDを取得する。
			 */
			RenderID = RenderingRegistry.getNextAvailableRenderId();

			/*
			 * ブロックのレンダラ―を設定する。 RenderingRegistry.registerBlockHandler(
			 * ISimpleBlockRenderingHandler);
			 */
			RenderingRegistry.registerBlockHandler(new RenderAnvilAluminium());

		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

	}
}