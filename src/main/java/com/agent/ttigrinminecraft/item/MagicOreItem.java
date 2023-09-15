package com.agent.ttigrinminecraft.item;

import com.agent.ttigrinminecraft.ThatTimeInMinecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class MagicOreItem extends Item {

    public MagicOreItem() {
        super(new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.RARE));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, @NotNull List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.GOLD + "Raw form of Magisteel."));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public static final DeferredRegister<Item> MOD_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThatTimeInMinecraft.MOD_ID);

    public static final RegistryObject<Item> MAGIC_ORE = MOD_ITEMS.register("magic_ore", MagicOreItem::new);

    public static void register(IEventBus eventBus) {
        MOD_ITEMS.register(eventBus);
    }
}
