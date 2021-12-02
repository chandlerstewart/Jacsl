// Main Contributor: Chandler Stewart

package net.fabricmc.jacsl.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

// This class is used for checks if it exists on an item
// all implementation is done in TeleportItemEntity
public class DiskOfTeleportationEnchantment extends Enchantment {

    public DiskOfTeleportationEnchantment(){
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }




}
