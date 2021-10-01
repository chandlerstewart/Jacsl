package net.fabricmc.jacsl.items;

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
import net.minecraft.world.World;
import java.util.List;

public class NewItem extends Item {


    public NewItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        double xVel = playerEntity.getVelocity().x;
        double yVel = playerEntity.getVelocity().x;
        double zVel = playerEntity.getVelocity().x;
        float pitch = 0.5f/(RANDOM.nextFloat()*.4f + .8f);

        playerEntity.setVelocity(xVel, yVel + 0.5, zVel);
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
