package com.kamesuta.mc.experimentalmod.sign;

import com.kamesuta.mc.experimentalmod.sign.tile.CustomTileEntitySignRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntitySign;

public class ClientProxy implements IBenchProxy
{
	//レンダーIDの取得
	@Override
	public int getNewRenderType()
	{
		return RenderingRegistry.getNextAvailableRenderId();
	}

	//カスタムレンダーの登録
	@Override
	public void registerRenderers()
	{
		final CustomTileEntitySignRenderer renderer = new CustomTileEntitySignRenderer();
		renderer.func_147497_a(TileEntityRendererDispatcher.instance);
		TileEntityRendererDispatcher.instance.mapSpecialRenderers.put(TileEntitySign.class, renderer);
		RenderingRegistry.registerBlockHandler(new RenderBenchBlock());
	}
}