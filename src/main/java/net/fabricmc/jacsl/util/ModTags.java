// Main Contributor: Sam Toje

package net.fabricmc.jacsl.util;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.jacsl.Main;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.nbt.TagReader;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items{

        public static final Tag<Item> helmettag = createTag("helmettag");

        private static Tag<Item> createTag(String name){
            return TagRegistry.item(new Identifier(Main.MODID, name));
        }

    }
}
