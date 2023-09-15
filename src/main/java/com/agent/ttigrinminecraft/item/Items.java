package com.agent.ttigrinminecraft.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class Items {
    public static final Item BUCKET = null; // Assuming this is a placeholder
    public static final Item MAGIC_ORE = new MagicOreItem();  // Adjusted the constructor here

    public Items() {
    }

    public static void register() {
        Registry.register(Registry.ITEM, new ResourceLocation("ThatTimeInMinecraft", "magic_ore"), MAGIC_ORE);
    }
}
