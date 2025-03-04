package mod.bespectacled.modernbetareleaseplus;

import mod.bespectacled.modernbetaforge.api.client.gui.GuiPredicate;
import mod.bespectacled.modernbetaforge.api.registry.ModernBetaClientRegistries;
import mod.bespectacled.modernbetareleaseplus.client.gui.GuiCustomizePresets;
import mod.bespectacled.modernbetareleaseplus.client.gui.GuiPredicates;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;

public class ModernBetaReleasePlusClientProxy implements ModernBetaReleasePlusProxy {
    @Override
    public void init() {
        ModernBetaClientRegistries.GUI_PRESET.register(
            GuiCustomizePresets.B1_8_1_KEY,
            GuiCustomizePresets.PRESET_B1_8_1
        );
        ModernBetaClientRegistries.GUI_PRESET.register(
            GuiCustomizePresets.R1_0_KEY,
            GuiCustomizePresets.PRESET_R1_0
        );
        ModernBetaClientRegistries.GUI_PRESET.register(
            GuiCustomizePresets.R1_1_KEY,
            GuiCustomizePresets.PRESET_R1_1
        );
        ModernBetaClientRegistries.GUI_PRESET.register(
            GuiCustomizePresets.R1_6_4_KEY,
            GuiCustomizePresets.PRESET_R1_6_4
        );
        
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.GENERATOR_VERSION, GuiPredicates.GENERATOR_VERSION_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.OCEAN, GuiPredicates.OCEAN_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.PLAINS, GuiPredicates.PLAINS_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.DESERT, GuiPredicates.DESERT_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.EXTREME_HILLS, GuiPredicates.HILLS_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.FOREST, GuiPredicates.FOREST_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.TAIGA, GuiPredicates.TAIGA_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.SWAMPLAND, GuiPredicates.SWAMPLAND_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.RIVER, GuiPredicates.RIVER_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.FROZEN_RIVER, GuiPredicates.FROZEN_RIVER_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.FROZEN_OCEAN, GuiPredicates.FROZEN_OCEAN_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.ICE_PLAINS, GuiPredicates.ICE_PLAINS_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.ICE_MOUNTAINS, GuiPredicates.ICE_MOUNTAINS_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.MUSHROOM_ISLAND, GuiPredicates.MUSHROOM_ISLAND_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.MUSHROOM_ISLAND_SHORE, GuiPredicates.MUSHROOM_ISLAND_SHORE_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.BEACH, GuiPredicates.BEACH_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.DESERT_HILLS, GuiPredicates.DESERT_HILLS_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.FOREST_HILLS, GuiPredicates.FOREST_HILLS_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.TAIGA_HILLS, GuiPredicates.TAIGA_HILLS_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.EXTREME_HILLS_EDGE, GuiPredicates.EXTREME_HILLS_EDGE_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.JUNGLE, GuiPredicates.JUNGLE_TEST);
        ModernBetaClientRegistries.GUI_PREDICATE.register(SettingTags.JUNGLE_HILLS, GuiPredicates.JUNGLE_HILLS_TEST);
        
        // Enable biome size setting for ReleasePlusBiomeSource
        ModernBetaClientRegistries.GUI_PREDICATE.get(GuiPredicate.BIOME_SIZE).or(settings -> settings.biomeSource.equals(SettingTags.BIOME_SOURCE));
    }
}
