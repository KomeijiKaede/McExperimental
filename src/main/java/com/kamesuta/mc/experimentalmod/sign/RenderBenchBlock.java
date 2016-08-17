package com.kamesuta.mc.experimentalmod.sign;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderBenchBlock implements ISimpleBlockRenderingHandler
{
	//インベントリ向け
	@Override
	public void renderInventoryBlock(final Block block, final int metadata, final int modelId, final RenderBlocks renderer)
	{
		if (modelId == getRenderId())
		{
			final Tessellator tessellator = Tessellator.instance;
			//ココをいじるとブロックの大きさが変わる
			renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);

			//描画位置の調整。ココをいじると、中心にレンダー持ってきたり、遊べる
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			//くコ:彡 、コピペ☆　RenderBlocksみてね
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, -1.0F, 0.0F);
			renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 1.0F, 0.0F);
			renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, -1.0F);
			renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, 1.0F);
			renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(-1.0F, 0.0F, 0.0F);
			renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
			tessellator.draw();
			//描画位置の調整。遊んだ後はお片づけ
			//上のヤツ→GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		}
	}

	//ワールドでのレンダー
	@Override
	public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer)
	{
		if (modelId == getRenderId())
		{
			//ココをいじればブロックの大きさが変わる。
			renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			//上2つのコードを複数回実行することで、階段やドラゴンエッグのようなレンダーができる
			return true;
		}
		return false;
	}

	//インベントリのレンダーが面倒くさいなら、ココをfalseに。テクスチャだけ表示されるようになる
	@Override
	public boolean shouldRender3DInInventory(final int modelId)
	{
		return true;
	}

	//レンダーIDを返す
	@Override
	public int getRenderId()
	{
		return BenchCore.blockRenderId;
	}
}