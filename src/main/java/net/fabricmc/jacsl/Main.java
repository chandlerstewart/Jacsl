package net.fabricmc.jacsl;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.jacsl.enchantments.KnockbackiumEnchantment;
import net.fabricmc.jacsl.items.AerogelSword;
import net.fabricmc.jacsl.items.NewItem;
import net.fabricmc.jacsl.items.DiskOfTeleportation;
import net.fabricmc.jacsl.materials.Aerogel;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Main implements ModInitializer {

	public static final String MODID = "jacsl";

	public static final ItemGroup NEW_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MODID, "general"),
			() -> new ItemStack(Main.NEW_ITEM));

	public static final Item NEW_ITEM = new NewItem(new FabricItemSettings().group(Main.NEW_ITEM_GROUP));
	public static final Item TELEPORT_ITEM = new DiskOfTeleportation(new FabricItemSettings().group(Main.NEW_ITEM_GROUP));
	public static final ToolItem AEROGEL_SWORD = new AerogelSword(Aerogel.INSTANCE, 1, 2f, new FabricItemSettings().group(Main.NEW_ITEM_GROUP));

	private static Enchantment KNOCKBACK_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, new Identifier(MODID, "knockbackium_enchantment"), new KnockbackiumEnchantment());


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MODID, "new_item"), NEW_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "disk_of_teleportation"), TELEPORT_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "aerogel_sword"), AEROGEL_SWORD);

		System.out.println("Hello Fabric world!");
	}
}
