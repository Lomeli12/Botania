/**
 * This class was created by <williewillus>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.client.integration.jei.manapool;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import vazkii.botania.common.block.ModBlocks;

import javax.annotation.Nonnull;
import java.util.Collection;

public class ManaPoolRecipeCategory implements IRecipeCategory {

    private final IDrawable background;
    private final String localizedName;
    private final IDrawable overlay;

    public ManaPoolRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.createBlankDrawable(168, 64);
        localizedName = StatCollector.translateToLocal("botania.nei.manaPool");
        overlay = guiHelper.createDrawable(new ResourceLocation("botania", "textures/gui/pureDaisyOverlay.png"),
                0, 0, 64, 46);
    }

    @Nonnull
    @Override
    public String getUid() {
        return "botania.manaPool";
    }

    @Nonnull
    @Override
    public String getTitle() {
        return localizedName;
    }

    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        overlay.draw(minecraft, 48, 0);
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
    }

    @Override
    public void drawAnimations(Minecraft minecraft) {}

    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
        if (!(recipeWrapper instanceof ManaPoolRecipeWrapper))
            return;

        ManaPoolRecipeWrapper wrapper = ((ManaPoolRecipeWrapper) recipeWrapper);
        int index = 0;

        recipeLayout.getItemStacks().init(index, true, 40, 12);
        if (wrapper.getInputs().get(0) instanceof Collection) {
            recipeLayout.getItemStacks().set(index, ((Collection<ItemStack>) wrapper.getInputs().get(0)));
        } else {
            recipeLayout.getItemStacks().set(index, ((ItemStack) wrapper.getInputs().get(0)));
        }

        index++;

        if (wrapper.getInputs().size() > 1) {
            // Has catalyst
            recipeLayout.getItemStacks().init(index, true, 20, 12);
            recipeLayout.getItemStacks().set(index, ((ItemStack) wrapper.getInputs().get(1)));
            index++;
        }

        recipeLayout.getItemStacks().init(index, true, 70, 12);
        recipeLayout.getItemStacks().set(index, new ItemStack(ModBlocks.pool, 1, 0));
        index++;

        recipeLayout.getItemStacks().init(index, false, 99, 12);
        if (wrapper.getOutputs().get(0) instanceof Collection) {
            recipeLayout.getItemStacks().set(index, ((Collection<ItemStack>) wrapper.getOutputs().get(0)));
        } else {
            recipeLayout.getItemStacks().set(index, ((ItemStack) wrapper.getOutputs().get(0)));
        }
    }

}
