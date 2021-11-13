package net.fabricmc.jacsl.materials;

import net.minecraft.client.sound.Sound;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class Rocket implements ArmorMaterial
{
    public static final Rocket shoes = new Rocket();

    int getDurability() {return 1500;};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return 100;
    }

    public int getProtectionAmount(EquipmentSlot slot) {return 1000;}


    public int getEnchantability() {return 50;}


    public SoundEvent getEquipSound() {return SoundEvents.ITEM_ARMOR_EQUIP_IRON;}

    public Ingredient getRepairIngredient(){return Ingredient.ofItems(Items.IRON_INGOT);}


    @Environment(EnvType.CLIENT)
    public String getName() {return "Rocket Shoes";}


    public float getToughness() {return  200;}


    public float getKnockbackResistance() {return 200;}
}
