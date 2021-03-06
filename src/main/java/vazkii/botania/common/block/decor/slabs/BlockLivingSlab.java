package vazkii.botania.common.block.decor.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockLivingSlab extends BlockModSlab {

	IBlockState sourceState;

	public BlockLivingSlab(boolean full, IBlockState state) {
		super(full, state.getBlock().getMaterial(), state.getBlock().getUnlocalizedName().replaceAll("tile.", "") + state.getBlock().getMetaFromState(state) + "Slab" + (full ? "Full" : ""));
		setStepSound(state.getBlock().stepSound);
		this.sourceState = state;
	}

}
