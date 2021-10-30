package net.fabricmc.jacsl;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.jacsl.items.NewItem;
import net.fabricmc.jacsl.items.DiskOfTeleportation;
import net.fabricmc.jacsl.items.PackedSnowballItem;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.fabricmc.jacsl.items.Knockbackium;
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
	public static final ToolItem KNOCKBACK_SWORD = new SwordItem(Knockbackium.INSTANCE, 10, 10.0F, new FabricItemSettings().group(Main.NEW_ITEM_GROUP));

	public static final Item packedSnowballItem = new PackedSnowballItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MODID, "new_item"), NEW_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "disk_of_teleportation"), TELEPORT_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "knockback_item"), KNOCKBACK_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "packed_snowball"), packedSnowballItem);
		System.out.println("Hello Fabric world!");
	}
}
