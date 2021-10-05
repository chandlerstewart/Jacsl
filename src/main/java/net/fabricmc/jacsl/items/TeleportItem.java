package net.fabricmc.jacsl.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class TeleportItem extends Item {

    public TeleportItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        float pitch = 0.5f/(RANDOM.nextFloat()*.4f + .8f);

        MinecraftClient client = MinecraftClient.getInstance();

        double xpos = client.crosshairTarget.getPos().x;
        double ypos = client.crosshairTarget.getPos().y;
        double zpos = client.crosshairTarget.getPos().z;

        playerEntity.teleport(xpos, ypos, zpos, true);
        playerEntity.playSound(SoundEvents.BLOCK_IRON_DOOR_CLOSE, 1.0f, pitch);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        tooltip.add(new TranslatableText("Example tooltip"));
        tooltip.add(new TranslatableText("Example colored tooltip").formatted(Formatting.GOLD));
    }
}
