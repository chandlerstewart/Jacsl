package net.fabricmc.jacsl.items;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.jacsl.Main;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.Tag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;


import java.util.List;

public class Mining_Helmet extends ArmorItem{

    private DefaultedList<ItemStack> equippedArmor;
    private boolean isEquipped = false;

    public Mining_Helmet(ArmorMaterial material, EquipmentSlot slot, Item group) {
        super(material, slot, new Item.Settings().group(Main.NEW_ITEM_GROUP));
    }

  /* @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(itemStack);
        ItemStack itemStack2 = playerEntity.getEquippedStack(equipmentSlot);
        //ItemStack helmetStack = equippedArmor.get(1);
        //while(helmetStack.getItem().equals(Main.MINING_HELMET) == true){
        //    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION));
       // }
        if (itemStack2.isEmpty()) {
            //playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION));
            playerEntity.equipStack(equipmentSlot, itemStack.copy());
            itemStack.setCount(0);
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }*/

    @Override
    public String toString() {
        return "Mining Helmet";
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {

        tooltip.add(new TranslatableText("A shining light in the darkness").formatted(Formatting.AQUA));

    }

}
