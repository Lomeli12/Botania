/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 29, 2015, 7:17:35 PM (GMT)]
 */
package vazkii.botania.common.block.decor.biomestone;

import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import vazkii.botania.api.state.BotaniaStateProps;
import vazkii.botania.api.state.enums.BiomeStoneVariant;
import vazkii.botania.common.lib.LibBlockNames;

public class BlockBiomeStoneA extends BlockBiomeStone {

	public BlockBiomeStoneA() {
		super(LibBlockNames.BIOME_STONE_A);
		setDefaultState(blockState.getBaseState().withProperty(BotaniaStateProps.BIOMESTONE_VARIANT, BiomeStoneVariant.FOREST));
	}

	@Override
	public BlockState createBlockState() {
		return new BlockState(this, BotaniaStateProps.BIOMESTONE_VARIANT);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BotaniaStateProps.BIOMESTONE_VARIANT).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta >= BiomeStoneVariant.values().length) {
			meta = 0;
		}
		return getDefaultState().withProperty(BotaniaStateProps.BIOMESTONE_VARIANT, BiomeStoneVariant.values()[meta]);
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = getMetaFromState(state);
		if (meta < 8) {
			meta += 8; // Drop cobblestone variant
		}
		return meta;
	}

}
