package net.fabricmc.jacsl.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class AerogelSword extends SwordItem {

    public AerogelSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    //sends the player forwards and upwards upon right-clicking with the sword
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        double xRot = playerEntity.getRotationVector().x;
        double yVel = playerEntity.getVelocity().y;
        double zRot = playerEntity.getRotationVector().z;
        float pitch = 0.5f/(RANDOM.nextFloat()*.4f + .8f);

        playerEntity.setVelocity(xRot*2f, yVel + 0.4f, zRot*2f);
        playerEntity.playSound(SoundEvents.ENTITY_PLAYER_BREATH, 1.0f, pitch);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        tooltip.add(new TranslatableText("Right-Click to lunge forwards").formatted(Formatting.LIGHT_PURPLE));
    }

}
