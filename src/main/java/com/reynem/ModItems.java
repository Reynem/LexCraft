package com.reynem;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.reynem.EmeraldApple.EMERALD_FOOD_COMPONENT;


public class ModItems {
    public static final Item SUSPICIOUS_SUBSTANCE = register(
            "suspicious_substance",
            SuspiciousSubstanceItem::new, // передаем сам класс
            new Item.Settings()
    );

    public static final Item EMERALD_APPLE = register(
            "emerald_apple",
            EmeraldApple::new,
            new Item.Settings().food(EMERALD_FOOD_COMPONENT)
    );



    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, new Identifier(LexMinecraft.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings);

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE);
                    itemGroup.add(ModItems.EMERALD_APPLE);
                });


        FuelRegistry.INSTANCE.add(ModItems.SUSPICIOUS_SUBSTANCE, 40 * 20);
    }

}