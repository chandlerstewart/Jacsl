package net.fabricmc.jacsl;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

public class ClientEntrypoint implements ClientModInitializer {

    private static KeyBinding keybinding_rocketBoots;
    private static KeyBinding keyBinding_miningHelmet;
    private int miningHelmetActivated = 2;

    @Override
    public void onInitializeClient() {

        keybinding_rocketBoots = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.jacsl.rocketboots",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "category.jacsl.custom"
        ));

        keyBinding_miningHelmet = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.jacsl.mininghelmet",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "category.jacsl.custom"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            while (keybinding_rocketBoots.wasPressed())
            {
                PlayerEntity user = MinecraftClient.getInstance().player;
                user.setVelocity(user.getVelocity().x,.5f,user.getVelocity().z);
                user.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0f, 1.0f);
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if (keyBinding_miningHelmet.wasPressed()){
                if (miningHelmetActivated == 0) miningHelmetActivated = 1;
                else miningHelmetActivated = 0;
            }

            if (miningHelmetActivated == 1) {
                PlayerEntity user = MinecraftClient.getInstance().player;
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION));
            } else if (miningHelmetActivated == 0) {
                PlayerEntity user = MinecraftClient.getInstance().player;
                user.removeStatusEffect(StatusEffects.NIGHT_VISION);
            }


        });
    }

}
