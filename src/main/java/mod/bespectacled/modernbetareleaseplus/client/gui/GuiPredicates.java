package mod.bespectacled.modernbetareleaseplus.client.gui;

import kaptainwutax.mcutils.version.MCVersion;
import mod.bespectacled.modernbetaforge.api.client.gui.GuiPredicate;
import mod.bespectacled.modernbetaforge.world.setting.ModernBetaGeneratorSettings;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;

public class GuiPredicates {
    public static final GuiPredicate GENERATOR_VERSION_TEST;
    public static final GuiPredicate BIOME_SIZE_TEST;
    
    public static final GuiPredicate OCEAN_TEST;
    public static final GuiPredicate PLAINS_TEST;
    public static final GuiPredicate DESERT_TEST;
    public static final GuiPredicate HILLS_TEST;
    public static final GuiPredicate FOREST_TEST;
    public static final GuiPredicate TAIGA_TEST;
    public static final GuiPredicate SWAMPLAND_TEST;
    public static final GuiPredicate RIVER_TEST;
    
    public static final GuiPredicate FROZEN_RIVER_TEST;
    public static final GuiPredicate FROZEN_OCEAN_TEST;
    public static final GuiPredicate ICE_PLAINS_TEST;
    public static final GuiPredicate ICE_MOUNTAINS_TEST;
    public static final GuiPredicate MUSHROOM_ISLAND_TEST;
    public static final GuiPredicate MUSHROOM_ISLAND_SHORE_TEST;
    
    public static final GuiPredicate BEACH_TEST;
    public static final GuiPredicate DESERT_HILLS_TEST;
    public static final GuiPredicate FOREST_HILLS_TEST;
    public static final GuiPredicate TAIGA_HILLS_TEST;
    public static final GuiPredicate EXTREME_HILLS_EDGE_TEST;
    
    public static final GuiPredicate JUNGLE_TEST;
    public static final GuiPredicate JUNGLE_HILLS_TEST;
    
    public static final GuiPredicate USE_DEEP_OCEANS_TEST;
    public static final GuiPredicate DEEP_OCEAN_CHANCE_TEST;
    public static final GuiPredicate DEEP_OCEAN_NOISE_SCALE_TEST;
    
    private static boolean isReleasePlus(ModernBetaGeneratorSettings settings) {
        return settings.biomeSource.equals(SettingTags.BIOME_SOURCE);
    }
    
    private static boolean isNewerOrEqualTo(ModernBetaGeneratorSettings settings, MCVersion version) {
        return MCVersion.fromString(settings.getListProperty(SettingTags.GENERATOR_VERSION)).isNewerOrEqualTo(version);
    }
    
    static {
        GENERATOR_VERSION_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        BIOME_SIZE_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        
        OCEAN_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        PLAINS_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        DESERT_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        HILLS_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        FOREST_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        TAIGA_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        SWAMPLAND_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        RIVER_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        
        FROZEN_RIVER_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_0));
        FROZEN_OCEAN_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_0));
        ICE_PLAINS_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_0));
        ICE_MOUNTAINS_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_0));
        MUSHROOM_ISLAND_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_0));
        MUSHROOM_ISLAND_SHORE_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_0));
        
        BEACH_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_1));
        DESERT_HILLS_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_1));
        FOREST_HILLS_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_1));
        TAIGA_HILLS_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_1));
        EXTREME_HILLS_EDGE_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_1));

        JUNGLE_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_2_1));
        JUNGLE_HILLS_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_2_1));
        
        USE_DEEP_OCEANS_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        DEEP_OCEAN_CHANCE_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && settings.getBooleanProperty(SettingTags.USE_DEEP_OCEANS));
        DEEP_OCEAN_NOISE_SCALE_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && settings.getBooleanProperty(SettingTags.USE_DEEP_OCEANS));
    }
}
