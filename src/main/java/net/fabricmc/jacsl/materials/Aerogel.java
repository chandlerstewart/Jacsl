package net.fabricmc.jacsl.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Aerogel implements ToolMaterial {

    public static final Aerogel INSTANCE = new Aerogel();

    @Override
    public int getDurability() {
        return 1200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0.25F;
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

    /*public Aerogel(Settings settings) {
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
