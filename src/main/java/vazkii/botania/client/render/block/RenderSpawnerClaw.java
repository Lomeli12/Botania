/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jul 23, 2014, 6:23:54 PM (GMT)]
 *//*

package vazkii.botania.client.render.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import vazkii.botania.client.lib.LibRenderIDs;
import vazkii.botania.common.block.tile.TileSpawnerClaw;
import net.minecraftforge.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderSpawnerClaw implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(-0.5F, 0F, -0.5F);
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileSpawnerClaw(), 0.0D, 0.0D, 0.0D, 0.0F);
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
		return LibRenderIDs.idSpawnerClaw;
	}

}
*/
