package net.fabricmc.jacsl.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
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

import java.text.Normalizer;
import java.util.List;

public class AerogelSword extends SwordItem {

    public AerogelSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    //Does nothing at the moment
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            //if target is a living thing then check its rotation and send it
            double xRot = user.getRotationVector().x;
            double zRot = user.getRotationVector().z;
            float pitch = 1.5f / ((float) Math.random() * .4f + .8f);

            target.setVelocity(xRot * 2f, 1.5f, zRot * 2f);
            target.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, pitch);
        }
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
