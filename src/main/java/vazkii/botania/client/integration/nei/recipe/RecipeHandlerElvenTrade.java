/*
package vazkii.botania.client.integration.nei.recipe;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.opengl.GL11;

import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.ILexicon;
import vazkii.botania.api.recipe.RecipeElvenTrade;
import vazkii.botania.client.lib.LibResources;
import vazkii.botania.common.block.BlockAlfPortal;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class RecipeHandlerElvenTrade extends TemplateRecipeHandler {

	public class CachedElvenTradeRecipe extends CachedRecipe {

		public List<PositionedStack> inputs = new ArrayList<PositionedStack>();
		public PositionedStack output;

		public CachedElvenTradeRecipe(RecipeElvenTrade recipe) {
			if(recipe == null)
				return;

			setIngredients(recipe.getInputs());
			output = new PositionedStack(recipe.getOutput(), 107, 46);
		}

		public void setIngredients(List<Object> inputs) {
			int i = 0;
			for(Object o : inputs) {
				if(o instanceof String)
					this.inputs.add(new PositionedStack(OreDictionary.getOres((String) o), 60 + i * 18, 6));
				else this.inputs.add(new PositionedStack(o, 60 + i * 18, 6));

				i++;
			}
		}

		@Override
		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 20, inputs);
		}

		@Override
		public PositionedStack getResult() {
			return output;
		}

	}

	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("botania.nei.elvenTrade");
	}

	@Override
	public String getGuiTexture() {
		return LibResources.GUI_NEI_BLANK;
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(35, 30, 48, 48), "botania.elvenTrade"));
	}

	@Override
	public int recipiesPerPage() {
		return 1;
	}

	@Override
	public void drawBackground(int recipe) {
		super.drawBackground(recipe);
		GlStateManager.enableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.7F);
		GuiDraw.changeTexture(LibResources.GUI_ELVEN_TRADE_OVERLAY);
		GuiDraw.drawTexturedModalRect(30, 10, 17, 17, 100, 80);
		GlStateManager.disableBlend();
		GuiDraw.changeTexture(TextureMap.locationBlocksTexture);
		renderIcon(35, 29, BlockAlfPortal.portalTex, 48, 48, 240); // todo 1.8
	}

	private static boolean hasElvenKnowledge() {
		*/
/*EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null) {
			for (ItemStack stack : player.inventory.mainInventory) {
				if (stack != null && stack.getItem() instanceof ILexicon) {
					ILexicon lexicon = (ILexicon) stack.getItem();
					if (lexicon.isKnowledgeUnlocked(stack, BotaniaAPI.elvenKnowledge)) {
						return true;
					}
				}
			}
		}
		return false;*//*

		return true;
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if(outputId.equals("botania.elvenTrade") && hasElvenKnowledge()) {
			if(hasElvenKnowledge()) {
				for(RecipeElvenTrade recipe : BotaniaAPI.elvenTradeRecipes) {
					if(recipe == null)
						continue;

					arecipes.add(new CachedElvenTradeRecipe(recipe));
				}
			}
		} else super.loadCraftingRecipes(outputId, results);
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		if(hasElvenKnowledge()) {
			for(RecipeElvenTrade recipe : BotaniaAPI.elvenTradeRecipes) {
				if(recipe == null)
					continue;

				if(NEIServerUtils.areStacksSameTypeCrafting(recipe.getOutput(), result))
					arecipes.add(new CachedElvenTradeRecipe(recipe));
			}
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		if(hasElvenKnowledge()) {
			for(RecipeElvenTrade recipe : BotaniaAPI.elvenTradeRecipes) {
				if(recipe == null)
					continue;

				CachedElvenTradeRecipe crecipe = new CachedElvenTradeRecipe(recipe);
				if(crecipe.contains(crecipe.inputs, ingredient))
					arecipes.add(crecipe);
			}
		}
	}

	public void renderIcon(int par1, int par2, TextureAtlasSprite par3Icon, int par4, int par5, int brightness) {
		Tessellator tessellator = Tessellator.getInstance();
		tessellator.getWorldRenderer().startDrawingQuads();
		tessellator.getWorldRenderer().setBrightness(brightness);
		tessellator.getWorldRenderer().addVertexWithUV(par1 + 0, par2 + par5, 0, par3Icon.getMinU(), par3Icon.getMaxV());
		tessellator.getWorldRenderer().addVertexWithUV(par1 + par4, par2 + par5, 0, par3Icon.getMaxU(), par3Icon.getMaxV());
		tessellator.getWorldRenderer().addVertexWithUV(par1 + par4, par2 + 0, 0, par3Icon.getMaxU(), par3Icon.getMinV());
		tessellator.getWorldRenderer().addVertexWithUV(par1 + 0, par2 + 0, 0, par3Icon.getMinU(), par3Icon.getMinV());
		tessellator.draw();
	}

}
*/
