package net.fabricmc.jacsl;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.jacsl.enchantments.DiskOfTeleportationEnchantment;
import net.fabricmc.jacsl.items.NewItem;
import net.fabricmc.jacsl.items.DiskOfTeleportation;
import net.fabricmc.jacsl.items.PackedSnowballItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.jacsl.enchantments.KnockbackiumEnchantment;
import net.fabricmc.jacsl.items.*;
import net.fabricmc.jacsl.materials.Aerogel;
import net.fabricmc.jacsl.materials.HelmetMaterial;
//import net.fabricmc.jacsl.mixin.NightVisionMixin;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ArmorItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.*;
import net.minecraft.server.command.AttributeCommand;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.time.chrono.MinguoChronology;
import java.util.jar.Attributes;


public class Main implements ModInitializer {

	public static final String MODID = "jacsl";

	public static final ItemGroup NEW_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MODID, "general"),
			() -> new ItemStack(Main.NEW_ITEM));


	public static final Item NEW_ITEM = new NewItem(new FabricItemSettings().group(Main.NEW_ITEM_GROUP));
	public static final Item TELEPORT_ITEM = new DiskOfTeleportation(new FabricItemSettings().group(Main.NEW_ITEM_GROUP));
	public static final Item AEROGEL_CUBE = new AerogelCube(new FabricItemSettings().group(Main.NEW_ITEM_GROUP));

	public static final Item MINING_HELMET = new ArmorItem(HelmetMaterial.MINEHELM, EquipmentSlot.HEAD, new FabricItemSettings().group(Main.NEW_ITEM_GROUP));
	//public static final Tag<Item> HELMETTAG = TagRegistry.item(new Identifier("jacsl", "helmettag"));

	//public static final StatusEffect NIGHT_VISION = new NightVisionMixin();

	//public static final Item ROCKET_SHOES = new RocketShoes(new FabricItemSettings().group(Main.NEW_ITEM_GROUP));

	public static final ToolItem AEROGEL_SWORD = new AerogelSword(Aerogel.INSTANCE, 1, 2f, new FabricItemSettings().group(Main.NEW_ITEM_GROUP));

	public static final Block AEROGEL_CHUNKS = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.0f));

	private static Enchantment KNOCKBACK_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, new Identifier(MODID, "knockbackium_enchantment"), new KnockbackiumEnchantment());
	public static Enchantment TELPORTATIONBOOM_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, new Identifier(MODID, "disk_of_teleportation_enchantment_explosion"), new DiskOfTeleportationEnchantment());
	public static Enchantment TELPORTATIONKNOCKBACK_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, new Identifier(MODID, "disk_of_teleportation_enchantment_knockback"), new DiskOfTeleportationEnchantment());


	public static final Item packedSnowballItem = new PackedSnowballItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MODID, "new_item"), NEW_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "disk_of_teleportation"), TELEPORT_ITEM);

//		Registry.register(Registry.ITEM, new Identifier(MODID, "knockback_item"), KNOCKBACK_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "packed_snowball"), packedSnowballItem);
		Registry.register(Registry.ITEM, new Identifier(MODID, "aerogel_sword"), AEROGEL_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "aerogel_cube"), AEROGEL_CUBE);
		//Registry.register(Registry.ITEM, new Identifier(MODID, "rocket_shoes"), ROCKET_SHOES);

		//Registering the aerogel blocks
		Registry.register(Registry.BLOCK, new Identifier(MODID, "aerogel_chunks"), AEROGEL_CHUNKS);
		Registry.register(Registry.ITEM, new Identifier(MODID, "aerogel_chunks"), new BlockItem(AEROGEL_CHUNKS, new FabricItemSettings().group(Main.NEW_ITEM_GROUP)));

		//Registering mining helmet and effect
		Registry.register(Registry.ITEM, new Identifier(MODID, "mining_helmet"), new Mining_Helmet(HelmetMaterial.MINEHELM, EquipmentSlot.HEAD, MINING_HELMET));

		//register(Registry.STATUS_EFFECT, new Identifier("jacsl", "night_vision"), NIGHT_VISION);

		System.out.println("Hello Fabric world!");
	}
}
