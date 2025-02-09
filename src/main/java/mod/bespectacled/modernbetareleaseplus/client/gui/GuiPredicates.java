package mod.bespectacled.modernbetareleaseplus.client.gui;

import kaptainwutax.mcutils.version.MCVersion;
import mod.bespectacled.modernbetaforge.api.client.gui.GuiPredicate;
import mod.bespectacled.modernbetaforge.world.setting.ModernBetaGeneratorSettings;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;

public class GuiPredicates {
    public static final GuiPredicate GENERATOR_VERSION_TEST;
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
    
    private static boolean isReleasePlus(ModernBetaGeneratorSettings settings) {
        return settings.biomeSource.equals(SettingTags.BIOME_SOURCE.toString());
    }
    
    private static boolean isNewerOrEqualTo(ModernBetaGeneratorSettings settings, MCVersion version) {
        return MCVersion.fromString(settings.getListProperty(SettingTags.GENERATOR_VERSION)).isNewerOrEqualTo(version);
    }
    
    static {
        GENERATOR_VERSION_TEST = new GuiPredicate(settings -> isReleasePlus(settings));
        OCEAN_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        PLAINS_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        DESERT_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        HILLS_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        FOREST_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        TAIGA_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        SWAMPLAND_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        RIVER_TEST = new GuiPredicate(GENERATOR_VERSION_TEST::test);
        
        FROZEN_RIVER_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_0));
        FROZEN_OCEAN_TEST = new GuiPredicate(FROZEN_RIVER_TEST::test);
        ICE_PLAINS_TEST = new GuiPredicate(FROZEN_RIVER_TEST::test);
        ICE_MOUNTAINS_TEST = new GuiPredicate(FROZEN_RIVER_TEST::test);
        MUSHROOM_ISLAND_TEST = new GuiPredicate(FROZEN_RIVER_TEST::test);
        MUSHROOM_ISLAND_SHORE_TEST = new GuiPredicate(FROZEN_RIVER_TEST::test);
        
        BEACH_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_1));
        DESERT_HILLS_TEST = new GuiPredicate(BEACH_TEST::test);
        FOREST_HILLS_TEST = new GuiPredicate(BEACH_TEST::test);
        TAIGA_HILLS_TEST = new GuiPredicate(BEACH_TEST::test);
        EXTREME_HILLS_EDGE_TEST = new GuiPredicate(BEACH_TEST::test);

        JUNGLE_TEST = new GuiPredicate(settings -> isReleasePlus(settings) && isNewerOrEqualTo(settings, MCVersion.v1_2_1));
        JUNGLE_HILLS_TEST = new GuiPredicate(JUNGLE_TEST::test);
    }
}
