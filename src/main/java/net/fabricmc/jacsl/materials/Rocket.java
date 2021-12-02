// Main Contributor: Alex Lopez

package net.fabricmc.jacsl.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

//create a Material class(Rocket) to add to the armor item class
public class Rocket implements ArmorMaterial
{
    //set the durability of the rocket
    @Override
    public int getDurability(EquipmentSlot slot) {
        return 100;
    }

    //set the protection of the rocket
    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return 3;
    }

    //set the enchantability of the rocket
    @Override
    public int getEnchantability() {
        return 0;
    }

    //set the sound when equipping the rocket
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    //set the repair ingredient
    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    //set a name for the rocket
    @Override
    public String getName() {
        return "rocket_shoes";
    }

    //set the toughness of the rocket
    @Override
    public float getToughness() {
        return 15F;
    }

    //set the resistance of the rocket
    @Override
    public float getKnockbackResistance() {
        return 10F;
    }
}
