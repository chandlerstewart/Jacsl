package net.fabricmc.jacsl.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import java.util.List;

public class Knockbackium implements ToolMaterial {

    public static final Knockbackium INSTANCE = new Knockbackium();

    @Override
    public int getDurability() {
        return 1000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 50.0F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 50;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }

    /*public Knockbackium(Settings settings) {
        super(settings);
    }*/

    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        double xVel = playerEntity.getVelocity().x;
        double yVel = playerEntity.getVelocity().y;
        double zVel = playerEntity.getVelocity().z;
        float pitch = 0.5f/(RANDOM.nextFloat()*.4f + .8f);

        playerEntity.setVelocity(xVel, yVel + 0.5, zVel);
        playerEntity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, pitch);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }*/

    /*@Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        tooltip.add(new TranslatableText("Wack people."));
        tooltip.add(new TranslatableText("HARD").formatted(Formatting.DARK_RED));
    }*/

}
