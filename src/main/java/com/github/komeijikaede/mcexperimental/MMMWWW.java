package com.github.komeijikaede.mcexperimental;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;

public class MMMWWW {
	public String ahyahyahya = "キチガイ";

	@SubscribeEvent
	public void onServerChat(ServerChatEvent event)
	{
		if (event.message.contains("fuck"))
		{
			EntityPlayerMP player = event.player;
			player.worldObj.createExplosion(
					player,
					player.getPlayerCoordinates().posX,
					player.getPlayerCoordinates().posY,
					player.getPlayerCoordinates().posZ,
					40F,
					false
			);

/*			player.worldObj.spawnEntityInWorld(new EntityTNTPrimed(
					player.worldObj,
					player.getPlayerCoordinates().posX,
					player.getPlayerCoordinates().posY,
					player.getPlayerCoordinates().posZ,
					player
			));
*///			sendServerChat("キチガイ");
		}
	}

	public static void sendServerChat(String msg)
	{
		ServerConfigurationManager sender = FMLCommonHandler.instance().getMinecraftServerInstance()
			.getConfigurationManager();

		String[] linemsg = msg.split("\n");
		for (String line : linemsg)
		{
			sender.sendChatMsg(new ChatComponentText(line));
		}
	}
}
