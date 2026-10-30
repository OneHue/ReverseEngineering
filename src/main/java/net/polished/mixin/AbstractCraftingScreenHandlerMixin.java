package net.polished.mixin;


import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.screen.AbstractCraftingScreenHandler;
import net.polished.craftingtable.CraftingInputSlot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractCraftingScreenHandler.class)
public class AbstractCraftingScreenHandlerMixin {


    @Shadow @Final private int width;
    @Shadow @Final private int height;
    @Shadow @Final protected RecipeInputInventory craftingInventory;

    /**
     * @author 1hue
     * @reason new slot inheriting class
     */

    @Overwrite
    public void addInputSlots(int x, int y) {
        for(int i = 0; i < this.width; ++i) {
            for(int j = 0; j < this.height; ++j) {
                ((ScreenHandlerAccessor) this).invokeAddSlot(new CraftingInputSlot(this.craftingInventory, j + i * this.width, x + j * 18, y + i * 18));
            }
        }
    }
}
