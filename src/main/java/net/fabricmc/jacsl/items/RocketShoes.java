package net.fabricmc.jacsl.items;

import net.fabricmc.jacsl.Main;
import net.fabricmc.jacsl.entities.TeleportItemEntity;
import net.minecraft.client.item.TooltipContext;
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

public class RocketShoes extends Item{
    public RocketShoes(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        playerEntity.setVelocity(playerEntity.getVelocity().x,.5,playerEntity.getVelocity().z);
        playerEntity.playSound(SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    public void appendToolTip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        tooltip.add(new TranslatableText("These shoes can make you fly"));
    }
}
