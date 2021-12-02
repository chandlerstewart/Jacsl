// Main Contributor: Josh Cox

package net.fabricmc.jacsl.enchantments;

import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KnockbackiumEnchantment extends KnockbackEnchantment {

    public KnockbackiumEnchantment() {
        super(Rarity.UNCOMMON, EquipmentSlot.MAINHAND);
    }

    //don't want to kill the thing, just send it flying
    @Override
    public int getMinPower(int level) {
        return 1;
    }

    //Overrides the normal Knockback enchantment's onTargetDamaged function which is called
    //  when the player hits an entity
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            //if target is a living thing then check its rotation and send it
            double xRot = user.getRotationVector().x;
            double zRot = user.getRotationVector().z;
            float pitch = 1.5f/((float)Math.random()*.4f + .8f);

            target.setVelocity(xRot*2f, 1.5f, zRot*2f);
            target.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, pitch);

            primeTnt(user.getEntityWorld(), target.getBlockPos(), user);
        }

        //call to the actual Knockback onTargetDamaged method
        super.onTargetDamaged(user, target, level);
    }

    //spawns tnt when an entity is hit
    private static void primeTnt(World world, BlockPos pos, LivingEntity igniter) {
        if (!world.isClient) {
            TntEntity tntEntity = new TntEntity(world, (double)pos.getX() + 0.5D, pos.getY(), (double)pos.getZ() + 0.5D, igniter);
            world.spawnEntity(tntEntity);
            world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

}
