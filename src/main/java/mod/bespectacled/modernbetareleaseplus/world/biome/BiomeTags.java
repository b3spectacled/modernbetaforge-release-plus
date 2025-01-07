package mod.bespectacled.modernbetareleaseplus.world.biome;

import net.minecraft.util.ResourceLocation;

public class BiomeTags {
    public static final ResourceLocation OCEAN = createBiomeKey("ocean");
    public static final ResourceLocation PLAINS = createBiomeKey("plains");
    public static final ResourceLocation DESERT = createBiomeKey("desert");
    public static final ResourceLocation EXTREME_HILLS = createBiomeKey("extreme_hills");
    public static final ResourceLocation FOREST = createBiomeKey("forest");
    public static final ResourceLocation TAIGA = createBiomeKey("taiga");
    public static final ResourceLocation SWAMPLAND = createBiomeKey("swampland");
    public static final ResourceLocation RIVER = createBiomeKey("river");
    public static final ResourceLocation FROZEN_OCEAN = createBiomeKey("frozen_ocean");
    public static final ResourceLocation FROZEN_RIVER = createBiomeKey("frozen_river");
    public static final ResourceLocation ICE_PLAINS = createBiomeKey("ice_flats");
    public static final ResourceLocation ICE_MOUNTAINS = createBiomeKey("ice_mountains");
    public static final ResourceLocation MUSHROOM_ISLAND = createBiomeKey("mushroom_island");
    public static final ResourceLocation MUSHROOM_ISLAND_SHORE = createBiomeKey("mushroom_island_shore");
    public static final ResourceLocation BEACH = createBiomeKey("beaches");
    public static final ResourceLocation DESERT_HILLS = createBiomeKey("desert_hills");
    public static final ResourceLocation FOREST_HILLS = createBiomeKey("forest_hills");
    public static final ResourceLocation TAIGA_HILLS = createBiomeKey("taiga_hills");
    public static final ResourceLocation EXTREME_HILLS_EDGE = createBiomeKey("smaller_extreme_hills");
    public static final ResourceLocation JUNGLE = createBiomeKey("jungle");
    public static final ResourceLocation JUNGLE_HILLS = createBiomeKey("jungle_hills");
            
    private static ResourceLocation createBiomeKey(String path) {
        return new ResourceLocation(path);
    }
}
