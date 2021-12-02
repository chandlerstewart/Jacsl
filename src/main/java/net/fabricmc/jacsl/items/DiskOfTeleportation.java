// Main Contributor: Chandler Stewart

package net.fabricmc.jacsl.items;

import net.fabricmc.jacsl.Main;
import net.fabricmc.jacsl.entities.TeleportItemEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
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

public class DiskOfTeleportation extends Item {


    public DiskOfTeleportation(Item.Settings settings) {
        super(settings);
    }

    // When the item is right-clicked it calls this use function
    // Player teleport implementation is available in TeleportItemEntity class
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        float pitch = 0.5f/(RANDOM.nextFloat()*.2f + .5f);
        ItemStack itemStack = playerEntity.getStackInHand(hand);

        if (!playerEntity.getItemCooldownManager().isCoolingDown(Main.TELEPORT_ITEM)) { // If item not on cooldown
            playerEntity.getItemCooldownManager().set(this, 100); // Set cooldown to 10 seconds
            TeleportItemEntity teleportItemEntity = new TeleportItemEntity(world, playerEntity, itemStack);
            teleportItemEntity.setItem(itemStack);
            teleportItemEntity.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0.0F, .5F, .5F); // Sets the direction and speed of item
            world.spawnEntity(teleportItemEntity);
            playerEntity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0f, pitch);
        } else {
            playerEntity.sendMessage(new LiteralText("Teleportation on Cooldown"), false);
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand), world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        tooltip.add(new TranslatableText("Step 1: Chuck this, Step 2: Teleport").formatted(Formatting.GOLD));
    }
}
