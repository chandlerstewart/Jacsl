package net.fabricmc.jacsl.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class RocketShoes extends ArmorItem
{
    //Create  a Rocket_Shoe class with arguments
    //Arguments: material, the slot its going in, and the settings to apply
    public RocketShoes(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        //send to the ArmorItem class
        super(material, slot, settings);
    }
}