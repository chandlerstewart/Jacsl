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

    /*
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(itemStack);
        ItemStack itemStack2 = user.getEquippedStack(equipmentSlot);
        if (itemStack2.isEmpty()) {
            user.equipStack(equipmentSlot, itemStack.copy());
            itemStack.setCount(0);
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }*/
}