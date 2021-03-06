/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jun 26, 2014, 7:32:16 PM (GMT)]
 */
package vazkii.botania.common.entity;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import vazkii.botania.common.block.ModBlocks;

import java.util.Map;

public class EntityVineBall extends EntityThrowable {

	public EntityVineBall(World par1World) {
		super(par1World);
		dataWatcher.addObject(30, 0F);
		dataWatcher.setObjectWatched(30);
	}

	public EntityVineBall(EntityPlayer player, boolean gravity) {
		super(player.worldObj, player);
		dataWatcher.addObject(30, gravity ? 0.03F : 0F);
		dataWatcher.setObjectWatched(30);
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1 != null) {
			EnumFacing dir = var1.sideHit;

			Map<EnumFacing, PropertyBool> propMap = ImmutableMap.of(EnumFacing.NORTH, BlockVine.NORTH, EnumFacing.SOUTH, BlockVine.SOUTH,
					EnumFacing.WEST, BlockVine.WEST, EnumFacing.EAST, BlockVine.EAST);

			if(dir != null && dir.getAxis() != EnumFacing.Axis.Y) {
				BlockPos pos = var1.getBlockPos().offset(dir);
				while(pos.getY() > 0) {
					Block block = worldObj.getBlockState(pos).getBlock();
					if(block.isAir(worldObj, pos)) {
						IBlockState state = ModBlocks.solidVines.getDefaultState().withProperty(propMap.get(dir.getOpposite()), true);
						worldObj.setBlockState(pos, state, 1 | 2);
						worldObj.playAuxSFX(2001, pos, Block.getStateId(state));
						pos = pos.down();
					} else break;
				}
			}

		}

		setDead();
	}

	@Override
	protected float getGravityVelocity() {
		return dataWatcher.getWatchableObjectFloat(30);
	}

}
