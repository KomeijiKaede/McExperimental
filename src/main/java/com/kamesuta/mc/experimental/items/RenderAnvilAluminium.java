package com.kamesuta.mc.experimental.items;
import org.lwjgl.opengl.GL11;

import com.kamesuta.mc.experimental.McExperimentalMod;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderAnvilAluminium implements ISimpleBlockRenderingHandler
{
	/**インベントリ内でブロックをレンダリングするメソッド。もしshouldRender3DInInventoryがfalseなら空でもいいかも。**/
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		if (modelId == this.getRenderId())
		{
			float f = 0;
			f = this.renderAlumiAnvil(block, renderer, metadata, f, 0.75F, 0.25F, 0.75F ,false);
			f = this.renderAlumiAnvil(block, renderer, metadata, f, 0.5F, 0.0625F, 0.625F ,false);
			f = this.renderAlumiAnvil(block, renderer, metadata, f, 0.25F, 0.3125F, 0.5F ,false);
			f = this.renderAlumiAnvil(block, renderer, metadata, f, 0.625F, 0.375F, 1.0F ,false);
			this.renderAlumiAnvil(block, renderer, metadata, f, 0.1F, 5F, 0.1F ,false);
		}
	}

	/**ワールド内でブロックをレンダリングするメソッド**/
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		if (modelId == this.getRenderId())
		{
			/*レンダリングする立方体のサイズを決めるメソッド。
			 * setRenderBounds(始点X, 始点Y, 始点Z, 終点X, 終点Y, 終点Z)*/
			renderer.setRenderBounds(0.1D, 0.0D, 0.1D, 0.9D, 0.2D, 0.9D);
			/*レンダリングするメソッド。
			 * renderStandardBlock(block, x, y, z);*/
			double a1 = 0d;
			double a2 = 0.1d;
			double b1 = 0.9d;
			double b2 = 1d;
			renderer.setRenderBounds(a1, a2, a2, b2, b1, b1);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(a2, a1, a2, b1, b2, b1);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(a2, a2, a1, b1, b1, b2);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setRenderBounds(b1, b1, b1, b2, b2, b2);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(b1, b1, a1, b2, b2, a2);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(b1, a1, b1, b2, a2, b2);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(b1, a1, a1, b2, a2, a2);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(a1, b1, b1, a2, b2, b2);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(a1, b1, a1, a2, b2, a2);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(a1, a1, b1, a2, a2, b2);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(a1, a1, a1, a1, a2, a2);
			renderer.renderStandardBlock(block, x, y, z);

			return true;
		}
		return false;
	}

	@Override
	/**インベントリ内で3Dレンダリングするか否かを返すメソッド**/
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	/**自身のレンダーIDを返すメソッド**/
	@Override
	public int getRenderId() {

		return McExperimentalMod.RenderID;
	}

	protected float renderAlumiAnvil(Block block , RenderBlocks renderer , int metadata , float sides1 , float sides2 , float sides3  , float sides4 , boolean flg)
	{
		/**詳しい説明はカット。ここは難しいため、基本的にはshouldRender3DInInventoryをfalseにすることをお勧めする。**/
		if(flg)
		{
			float f = sides2;
			sides2 = sides4;
			sides4 =f;
		}
		sides2 /= 2.0F;
        sides4 /= 2.0F;
		renderer.setRenderBounds((double)(0.5F - sides2), (double)sides1, (double)(0.5F - sides4), (double)(0.5F + sides2), (double)(sides1 + sides3), (double)(0.5F + sides4));
		/*これより下は、ブロックを各面ごとにレンダリングしている。*/
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
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
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		return sides1 + sides3;
	}
}