
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.itemgroup.ElementalGearsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class NatureArmorItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:naturearmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("elementalmaster:naturearmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("elementalmaster:naturearmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("elementalmaster:naturearmor_boots")
	public static final Item boots = null;
	public NatureArmorItem(ElementalmasterModElements instance) {
		super(instance, 169);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 45;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{6, 18, 15, 6}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 27;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NatureIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "naturearmor";
			}

			public float getToughness() {
				return 3f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "elementalmaster:textures/models/armor/nature_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("naturearmor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "elementalmaster:textures/models/armor/nature_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("naturearmor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "elementalmaster:textures/models/armor/nature_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("naturearmor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "elementalmaster:textures/models/armor/nature_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("naturearmor_boots"));
	}
}
