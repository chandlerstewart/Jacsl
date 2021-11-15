package net.fabricmc.jacsl.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class Rocket implements ArmorMaterial
{

    @Override
    public int getDurability(EquipmentSlot slot) {
        return 100;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return "rocket_shoes";
    }

    @Override
    public float getToughness() {
        return 15F;
    }

    @Override
    public float getKnockbackResistance() {
        return 10F;
    }
}
