// Main Contributor: Josh Cox

package net.fabricmc.jacsl.materials;

import net.fabricmc.jacsl.Main;
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
        return Ingredient.ofItems(Main.AEROGEL_CUBE);
    }


}
