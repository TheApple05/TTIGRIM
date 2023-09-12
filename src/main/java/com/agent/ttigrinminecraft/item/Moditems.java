// THIS IS A FUCKIN MESS PLZ IGNORE IT OR I'LL YELL AND SCREM

package com.agent.ttigrinminecraft.item;

import com.agent.ttigrinminecraft.ThatTimeInMinecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThatTimeInMinecraft.MOD_ID);

    public static final RegistryObject<Item> MAGIC_ORE = Items.register("magic_ore",
            () -> {
                return new Item(new Item.Properties()
                        .tab(ItemGroup.TAB_BUILDING_BLOCKS)
                        .rarity(Rarity.RARE)
                        .setISTER(() -> MagicOreItemRenderer::new) // If you want a custom renderer
                        .addInformation((stack, world, tooltip, flag) -> {
                            tooltip.add_new(new StringTextComponent(TextFormatting.GOLD + "Raw form of Magisteel."));
                            // Add more lore as needed
                        }));
            });

    public static final RegistryObject<Item> MAGIC_ORE = Items.register("magic_ore",
            () -> new Item(new Item.Properties()
                    .tab(ItemGroup.TAB_BUILDING_BLOCKS)
                    .rarity(Rarity.RARE)
                    .setISTER(() -> MagicOreItemRenderer::new) // If you want a custom renderer
                    .addInformation((stack, world, tooltip, flag) -> {
                        tooltip.add_new (new StringTextComponent(TextFormatting.GOLD + "Raw form of Magisteel."));
                        // Add more lore as needed
                    })));

    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}
