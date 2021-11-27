//Lucas Pillaga
//project JACSL


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

// Creates class hotcheeto from class item, subclass relationship
public class HotCheeto extends Item {


    public HotCheeto(Settings settings) {
        super(settings);
    }
//create item in player hotbar
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
	
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
//this esnure the item is able to be thrown and another item and return nothting	    
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
