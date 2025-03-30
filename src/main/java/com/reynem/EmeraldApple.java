package com.reynem;

import net.minecraft.client.item.TooltipType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class EmeraldApple extends Item {
    public static final FoodComponent EMERALD_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(10)
            .saturationModifier(1)
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 80 * 20, 2), 1.0f)
            .build();

    public EmeraldApple(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.lexmine-craft.emerald_apple").formatted(Formatting.GOLD));
    }
}
