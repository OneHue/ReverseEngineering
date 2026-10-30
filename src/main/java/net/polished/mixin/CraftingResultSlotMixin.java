package net.polished.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CraftingResultSlot.class)
public class CraftingResultSlotMixin {
	/**
	 * @author 1hue & viboten
	 * @reason reverse engineering
	 */

	@Overwrite
	public boolean canInsert(ItemStack stack) {
		return true;
	}


}