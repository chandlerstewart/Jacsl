package net.fabricmc.jacsl.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.jacsl.materials.HelmetMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import javax.lang.model.element.TypeElement;
import java.lang.reflect.Type;
import java.util.List;

public class mining_helmet extends ArmorItem{

    public mining_helmet(ArmorItem settings){
        super();

    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        tooltip.add(new TranslatableText(" "));
        tooltip.add(new TranslatableText("A shining light in the darkness").formatted(Formatting.AQUA));
        tooltip.add(new TranslatableText("When on head:").formatted(Formatting.GRAY));
        tooltip.add(new TranslatableText("+2 Armor").formatted(Formatting.BLUE));
    }
}
