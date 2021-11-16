package net.fabricmc.jacsl.enchantments;

import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KnockbackiumEnchantment extends KnockbackEnchantment {

    public KnockbackiumEnchantment() {
        super(Rarity.UNCOMMON, EquipmentSlot.MAINHAND);
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

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

        super.onTargetDamaged(user, target, level);
    }

    //spawns tnt when an entity is hit
    private static void primeTnt(World world, BlockPos pos, LivingEntity igniter) {
        if (!world.isClient) {
            TntEntity tntEntity = new TntEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, igniter);
            world.spawnEntity(tntEntity);
            world.playSound((PlayerEntity)null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

}
