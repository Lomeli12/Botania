/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jul 26, 2014, 1:42:17 PM (GMT)]
 */
package vazkii.botania.common.block.subtile.generating;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileGenerating;
import vazkii.botania.common.lexicon.LexiconData;
import vazkii.botania.common.lib.LibObfuscation;

public class SubTileGourmaryllis extends SubTileGenerating {

	private static final String TAG_COOLDOWN = "cooldown";
	private static final int RANGE = 1;

	int cooldown = 0;
	int storedMana = 0;

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(cooldown > 0)
			cooldown--;
		if(cooldown == 0 && !supertile.getWorld().isRemote) {
			mana = Math.min(getMaxMana(), mana + storedMana);
			storedMana = 0;
			sync();
		}

		int slowdown = getSlowdownFactor();

		boolean remote = supertile.getWorld().isRemote;
		List<EntityItem> items = supertile.getWorld().getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(supertile.getPos().add(-RANGE, -RANGE, -RANGE), supertile.getPos().add(RANGE + 1, RANGE + 1, RANGE + 1)));

		for(EntityItem item : items) {
			ItemStack stack = item.getEntityItem();
			if(stack != null && stack.getItem() instanceof ItemFood && !item.isDead && ((Integer) ObfuscationReflectionHelper.getPrivateValue(EntityItem.class, item, LibObfuscation.AGE)) >= slowdown) {
				if(cooldown == 0) {
					if(!remote) {
						int val = ((ItemFood) stack.getItem()).getHealAmount(stack);
						storedMana = val * val * 64;
						cooldown = val * 10;
						supertile.getWorld().playSoundEffect(supertile.getPos().getX(), supertile.getPos().getY(), supertile.getPos().getZ(), "random.eat", 0.2F, 0.5F + (float) Math.random() * 0.5F);
						sync();
					} else 
						for(int i = 0; i < 10; i++) {
							float m = 0.2F;
							float mx = (float) (Math.random() - 0.5) * m;
							float my = (float) (Math.random() - 0.5) * m;
							float mz = (float) (Math.random() - 0.5) * m;
							supertile.getWorld().spawnParticle(EnumParticleTypes.ITEM_CRACK, item.posX, item.posY, item.posZ, mx, my, mz, Item.getIdFromItem(stack.getItem()), stack.getItemDamage());
						}
							
				}

				if(!remote)
					item.setDead();
			}
		}
	}

	@Override
	public void writeToPacketNBT(NBTTagCompound cmp) {
		super.writeToPacketNBT(cmp);
		cmp.setInteger(TAG_COOLDOWN, cooldown);
		cmp.setInteger(TAG_COOLDOWN, cooldown);
	}

	@Override
	public void readFromPacketNBT(NBTTagCompound cmp) {
		super.readFromPacketNBT(cmp);
		cooldown = cmp.getInteger(TAG_COOLDOWN);
	}

	@Override
	public RadiusDescriptor getRadius() {
		return new RadiusDescriptor.Square(toBlockPos(), RANGE);
	}

	@Override
	public int getMaxMana() {
		return 8000;
	}

	@Override
	public int getColor() {
		return 0xD3D604;
	}

	@Override
	public LexiconEntry getEntry() {
		return LexiconData.gourmaryllis;
	}

}
