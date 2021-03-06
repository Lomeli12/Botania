/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jun 29, 2015, 5:00:30 PM (GMT)]
 */
package vazkii.botania.client.gui.lexicon.button;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import vazkii.botania.client.challenge.Challenge;

public class GuiButtonChallengeIcon extends GuiButtonLexicon {

	public Challenge challenge;

	public GuiButtonChallengeIcon(int id, int x, int y, Challenge challenge) {
		super(id, x, y, 16, 16, "");
		this.challenge = challenge;
	}

	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		hovered = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
		int k = getHoverState(hovered);

		RenderHelper.enableGUIStandardItemLighting();
		GlStateManager.enableRescaleNormal();
		par1Minecraft.getRenderItem().renderItemIntoGUI(challenge.icon, xPosition, yPosition);
		RenderHelper.disableStandardItemLighting();
		GlStateManager.enableBlend();

		if(challenge.complete) {
			GlStateManager.disableDepth();
			par1Minecraft.fontRendererObj.drawStringWithShadow("\u2714", xPosition + 10, yPosition + 9, 0x004C00);
			par1Minecraft.fontRendererObj.drawStringWithShadow("\u2714", xPosition + 10, yPosition + 8, 0x0BD20D);
			GlStateManager.enableDepth();
		}


		List<String> tooltip = new ArrayList();
		tooltip.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal(challenge.unlocalizedName));

		int tooltipY = (tooltip.size() - 1) * 10;
		if(k == 2)
			vazkii.botania.client.core.helper.RenderHelper.renderTooltip(par2, par3 + tooltipY, tooltip);
	}

}
