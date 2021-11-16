package net.fabricmc.jacsl.items;

import net.fabricmc.jacsl.entities.HotCheetoEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class HotCheeto extends Item {

  //  PlayerEntity playerEntity;
    public HotCheeto(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
		/*
		user.getItemCooldownManager().set(this, 5);
		Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
		*/
        if (!world.isClient) {
            HotCheetoEntity hotCheetoEntity = new HotCheetoEntity(world, user);
            hotCheetoEntity.setItem(itemStack);
            hotCheetoEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
            world.spawnEntity(hotCheetoEntity); // spawns entity
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.abilities.creativeMode) {
            itemStack.decrement(1); // decrements itemStack if user is not in creative mode
        }
//leave like this so it wont break!!!!
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
