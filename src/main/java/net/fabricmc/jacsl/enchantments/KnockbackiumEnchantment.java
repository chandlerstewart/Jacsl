package net.fabricmc.jacsl.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.SoundEvents;

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
        }

        super.onTargetDamaged(user, target, level);
    }

}
