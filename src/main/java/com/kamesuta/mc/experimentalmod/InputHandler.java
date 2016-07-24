package com.kamesuta.mc.experimentalmod;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;

public class InputHandler {
	public static final InputHandler INSTANCE = new InputHandler();

	private static final KeyBinding KEY_BINDING_CONTROL = new KeyBinding("mc.ctrl", Keyboard.KEY_SUBTRACT, "mc.category");

	public static final KeyBinding[] KEY_BINDINGS = new KeyBinding[] { KEY_BINDING_CONTROL };

	private InputHandler() {
	}

	@SubscribeEvent
	public void onKeyInput(final InputEvent event) {
		if (KEY_BINDING_CONTROL.isPressed()) {
			//MinecraftServer.getServer().getCommandManager().executeCommand(MinecraftServer.getServer(), "/give @p stone");
			final ItemStack i = Minecraft.getMinecraft().thePlayer.getHeldItem();

			ChatUtil.sendServerChat(i.func_151000_E());
		}
	}
}
