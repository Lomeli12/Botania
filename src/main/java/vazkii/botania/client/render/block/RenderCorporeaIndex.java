/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Feb 15, 2015, 1:57:50 AM (GMT)]
 */
/*
package vazkii.botania.client.render.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import vazkii.botania.client.lib.LibRenderIDs;
import vazkii.botania.client.render.tile.RenderTileCorporeaIndex;
import vazkii.botania.common.block.tile.corporea.TileCorporeaIndex;
import net.minecraftforge.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderCorporeaIndex implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(-0.5F, -0.3F, -0.5F);
		GlStateManager.scale(1.4F, 1.4F, 1.4F);
		RenderTileCorporeaIndex.move = false;
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileCorporeaIndex(), 0.0D, 0.0D, 0.0D, 0.0F);
		RenderTileCorporeaIndex.move = true;
		GlStateManager.popMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return LibRenderIDs.idCorporeaIndex;
	}

}
*/
