package net.fabricmc.jacsl.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class DiskOfTeleportationEnchantment extends Enchantment {

    public DiskOfTeleportationEnchantment(){
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }




}
