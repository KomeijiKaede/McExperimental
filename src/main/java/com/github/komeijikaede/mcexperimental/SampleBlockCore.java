package com.github.komeijikaede.mcexperimental;

import java.util.Queue;

import org.apache.logging.log4j.LogManager;

import com.github.komeijikaede.mcexperimental.SampleBlock.BlockAdded;
import com.google.common.collect.Queues;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=SampleBlockCore.MOD_ID, name="BlockSampleMod", version="1.0")
public class SampleBlockCore
{
       public static final String MOD_ID = "BlockSampleMod";
	public static SampleBlock blockSample;
	public static org.apache.logging.log4j.Logger logger= LogManager.getLogger("BlockSampleMod");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//ブロックのインスタンス生成
		blockSample = new SampleBlock();
		//ブロックの登録。登録文字列はMOD内で被らなければ何でも良い。
		GameRegistry.registerBlock(blockSample, "blockSample");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(this);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new Command());
	}

	   public static Queue<BlockAdded> queue = Queues.newArrayDeque();

	   @SubscribeEvent
	   public void onServerTick(ServerTickEvent event) {
		   if (event.phase== Phase.START) {
		   BlockAdded line;
		   while ((line=queue.poll())!=null) {
			   line.world.setBlock(line.x+1, line.y, line.z, SampleBlockCore.blockSample);
			   line.world.setBlock(line.x-1, line.y, line.z, SampleBlockCore.blockSample);
			   line.world.setBlock(line.x, line.y, line.z+1, SampleBlockCore.blockSample);
			   line.world.setBlock(line.x, line.y, line.z-1, SampleBlockCore.blockSample);
		   }
		   }
	   }
}