
package net.bukkit.elementalmaster.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.bukkit.elementalmaster.itemgroup.ElementalBlocksItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.List;
import java.util.Collections;

@ElementalmasterModElements.ModElement.Tag
public class DarkQuartzStairsBlock extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:dark_quartz_stairs")
	public static final Block block = null;
	public DarkQuartzStairsBlock(ElementalmasterModElements instance) {
		super(instance, 67);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ElementalBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK)).getDefaultState(), Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
					.hardnessAndResistance(2f, 10f).lightValue(0).harvestLevel(1).harvestTool(ToolType.PICKAXE));
			setRegistryName("dark_quartz_stairs");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
