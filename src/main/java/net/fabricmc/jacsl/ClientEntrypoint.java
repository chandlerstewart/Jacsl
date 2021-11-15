package net.fabricmc.jacsl;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EquipmentSlot;
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

    private static KeyBinding keybinding;
    private static World world;
    private static Hand hand;

    @Override
    public void onInitializeClient() {

        keybinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.jacsl.rocketboots",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "category.jacsl.custom"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keybinding.wasPressed())
            {
                PlayerEntity user = MinecraftClient.getInstance().player;
                float pitch = 1.5f / ((float) Math.random() * .4f + .8f);
                user.setVelocity(user.getVelocity().x,.5f,user.getVelocity().z);
                user.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0f, pitch);
            }
        });
    }

}
