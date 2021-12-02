// Main Contributor: Chandler Stewart

package net.fabricmc.jacsl;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import org.lwjgl.glfw.GLFW;

public class ClientEntrypoint implements ClientModInitializer {

    private static KeyBinding keybinding_rocketBoots;
    private static KeyBinding keyBinding_miningHelmet;
    private int miningHelmetActivated = 2; // status flag for current helmet activation status

    // This function is called whenever minecraft is initialized on the client's side
    @Override
    public void onInitializeClient() {

        keybinding_rocketBoots = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.jacsl.rocketboots",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "category.jacsl.custom"
        )); // create keybinding for rocket_boots item [J] key

        keyBinding_miningHelmet = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.jacsl.mininghelmet",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "category.jacsl.custom"
        )); // create keybinding for mining_helmet item [G] key

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            // while rocket boots keybinding pressed, make the player fly
            while (keybinding_rocketBoots.wasPressed())
            {
                PlayerEntity user = MinecraftClient.getInstance().player;
                user.setVelocity(user.getVelocity().x,.5f,user.getVelocity().z);
                user.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0f, 1.0f);
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            // miningHelmetActivated 0: not active
            // miningHelmetActivated 1: active
            // miningHelmetActivated 2: not initialized (does not call anything until initialized)
            if (keyBinding_miningHelmet.wasPressed()){
                if (miningHelmetActivated == 0) miningHelmetActivated = 1;
                else miningHelmetActivated = 0;
            }

            // if helmet is activated
            if (miningHelmetActivated == 1) {
                PlayerEntity user = MinecraftClient.getInstance().player;

                boolean isEquipped = false;
                for (ItemStack itemStack : user.getArmorItems()){ // check if mining helmet is equipped in armor items
                    Item item = itemStack.getItem();

                    if (item.toString() == "Mining Helmet") isEquipped = true;
                }

                if (isEquipped) // if helmet is equipped, create night_vision status effect
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION));
                else
                    miningHelmetActivated = 0;
            }

            if (miningHelmetActivated == 0) { // if helmet is not activated remove any active night_vision status affect
                PlayerEntity user = MinecraftClient.getInstance().player;
                user.removeStatusEffect(StatusEffects.NIGHT_VISION);
            }

        });
    }

}
