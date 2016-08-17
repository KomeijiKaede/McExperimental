package com.kamesuta.mc.experimentalmod.sign;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@Mod( modid = "samplebench", name = "Sample Bench", version = "1.0.0")
public class BenchCore
{
	//Block関係の変数。コンフィグなどは各自で
	public static Block blockBench;
	public static int benchBlockId = 3000;

	//レンダー関係。Proxyを使い、クライアント側でレンダーの登録などを行う
	@SidedProxy(clientSide = "com.kamesuta.mc.experimentalmod.sign.ClientProxy", serverSide = "com.kamesuta.mc.experimentalmod.sign.ServerProxy")
	public static IBenchProxy proxy;
	//ブロックのメソッドgetRenderType()で返す独自レンダーの値
	public static int blockRenderId;

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event)
	{
		blockBench = new BlockBench(benchBlockId);
		GameRegistry.registerBlock(blockBench, "blockBench");
	}

	@EventHandler
	public void init(final FMLInitializationEvent event)
	{
		//Proxyの実行
		blockRenderId = proxy.getNewRenderType();
		proxy.registerRenderers();
	}
}