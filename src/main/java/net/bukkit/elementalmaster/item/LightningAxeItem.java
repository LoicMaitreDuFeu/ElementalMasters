
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.bukkit.elementalmaster.itemgroup.ElementalGearsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class LightningAxeItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:lightningaxe")
	public static final Item block = null;
	public LightningAxeItem(ElementalmasterModElements instance) {
		super(instance, 145);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1164;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LightningIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
		}.setRegistryName("lightningaxe"));
	}
}
