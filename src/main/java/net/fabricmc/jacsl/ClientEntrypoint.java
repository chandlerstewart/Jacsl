package net.fabricmc.jacsl;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class ClientEntrypoint implements ClientModInitializer {

    private static KeyBinding keybinding;


    @Override
    public void onInitializeClient() {

        keybinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.jacsl.rocketboots",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "category.jacsl.custom"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keybinding.wasPressed()) {
                System.out.println("AAAAAAAAAA");
            }
        });
    }
}
