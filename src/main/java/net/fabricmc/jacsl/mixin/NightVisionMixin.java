package net.fabricmc.jacsl.mixin;

import javafx.scene.effect.Effect;
import net.fabricmc.jacsl.Main;
import net.fabricmc.jacsl.items.Mining_Helmet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class NightVisionMixin extends Entity {

    @Shadow @Final private DefaultedList<ItemStack> equippedArmor;

    public NightVisionMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        ItemStack helmetStack = equippedArmor.get(1);

        //System.out.println(helmetStack);
        //System.out.println(Main.MINING_HELMET);
        //System.out.println(helmetStack.getItem());
        if (helmetStack.getItem().equals(Main.MINING_HELMET) == true) {
            System.out.println("TEST1");
            //.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION));
        }

    }

}
/*
    private DefaultedList<ItemStack> equippedArmor;
    public NightVisionMixin() {
        super(
                StatusEffectType.BENEFICIAL, // whether beneficial or harmful for entities
                2039713); // color in RGB
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        ItemStack helmetStack = equippedArmor.get(3);
        System.out.println("TEST");
        if(helmetStack.getItem().equals(Main.MINING_HELMET)){
            return true;
        }
        return false;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION)); // Higher amplifier gives you EXP faster
        }
    }
}/*

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;

public class ExpStatusEffect extends StatusEffect {
    public ExpStatusEffect() {
        super(
                StatusEffectType.BENEFICIAL, // whether beneficial or harmful for entities
                0x98D982); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you EXP faster
        }
    }
}*/