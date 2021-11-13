package net.fabricmc.jacsl.items;

import net.fabricmc.jacsl.Main;
import net.fabricmc.jacsl.entities.TeleportItemEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

/*
public class RocketShoes extends Item{
    public RocketShoes(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        playerEntity.setVelocity(playerEntity.getVelocity().x,.5,playerEntity.getVelocity().z);
        playerEntity.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    public void appendToolTip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        tooltip.add(new TranslatableText("These shoes can make you fly"));
    }
}*/

public class RocketShoes extends ArmorItem
{

    public RocketShoes(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(itemStack);
        ItemStack itemStack2 = user.getEquippedStack(equipmentSlot);
        if (itemStack2.isEmpty()) {
            user.equipStack(equipmentSlot, itemStack.copy());
            user.setVelocity(user.getVelocity().x,.5,user.getVelocity().z);
            user.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0F, 1.0F);
            itemStack.setCount(0);
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }
}