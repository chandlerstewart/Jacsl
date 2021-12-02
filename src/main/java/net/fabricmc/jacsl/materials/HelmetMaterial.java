// Main Contributor: Sam Toje

package net.fabricmc.jacsl.materials;


import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum HelmetMaterial implements ArmorMaterial {
    /*
    private static final int[] baseDurability = new int[] { 128, 144, 160, 112};
    private static final int[] protectionAmounts = new int[] { 4, 10, 12, 6};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDurability[slot.getEntitySlotId()] * 25;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 1;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return "mining helmet";
    }

    @Override
    public float getToughness() {
        return 2;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
    */
    MINEHELM("minehelm", 1, new int[] {4, 7, 9, 4}, 17, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4f, 0, StatusEffects.NIGHT_VISION);
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorVal;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final StatusEffect vision;

    HelmetMaterial(String name, int durabilityMultiplier, int[] armorVal, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, StatusEffect vision){

        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorVal = armorVal;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.vision = vision;


    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.armorVal[1];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }


};
