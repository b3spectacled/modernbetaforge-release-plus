package mod.bespectacled.modernbetareleaseplus.world.biome;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;

import mod.bespectacled.modernbetaforge.world.setting.ModernBetaGeneratorSettings;
import mod.bespectacled.modernbetareleaseplus.ModernBetaReleasePlus;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class BiomeMap {
    private final Map<kaptainwutax.biomeutils.biome.Biome, Biome> biomeMap;
    
    public BiomeMap(ModernBetaGeneratorSettings settings) {
        this.biomeMap = this.createBiomeMap(settings);
    }
    
    public Biome getBiome(kaptainwutax.biomeutils.biome.Biome biome) {
        if (!this.biomeMap.containsKey(biome)) {
            ModernBetaReleasePlus.log(Level.WARN, String.format("Biome '%s' was not found in biome map!", biome.getName()));
            
            return Biomes.PLAINS;
        }
        
        return this.biomeMap.get(biome);
    }

    private Map<kaptainwutax.biomeutils.biome.Biome, Biome> createBiomeMap(ModernBetaGeneratorSettings settings) {
        Map<kaptainwutax.biomeutils.biome.Biome, Biome> biomeMap = new LinkedHashMap<>();
        
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.OCEAN,
            settings.getBiomeProperty(SettingTags.OCEAN)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.PLAINS,
            settings.getBiomeProperty(SettingTags.PLAINS)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.DESERT,
            settings.getBiomeProperty(SettingTags.DESERT)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.EXTREME_HILLS,
            settings.getBiomeProperty(SettingTags.EXTREME_HILLS)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.FOREST,
            settings.getBiomeProperty(SettingTags.FOREST)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.TAIGA,
            settings.getBiomeProperty(SettingTags.TAIGA)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.SWAMPLAND,
            settings.getBiomeProperty(SettingTags.SWAMPLAND)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.RIVER,
            settings.getBiomeProperty(SettingTags.RIVER)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.FROZEN_OCEAN,
            settings.getBiomeProperty(SettingTags.FROZEN_OCEAN)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.FROZEN_RIVER,
            settings.getBiomeProperty(SettingTags.FROZEN_RIVER)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.ICE_PLAINS,
            settings.getBiomeProperty(SettingTags.ICE_PLAINS)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.ICE_MOUNTAINS,
            settings.getBiomeProperty(SettingTags.ICE_MOUNTAINS)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.MUSHROOM_ISLAND,
            settings.getBiomeProperty(SettingTags.MUSHROOM_ISLAND)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.MUSHROOM_ISLAND_SHORE,
            settings.getBiomeProperty(SettingTags.MUSHROOM_ISLAND_SHORE)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.BEACH,
            settings.getBiomeProperty(SettingTags.BEACH)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.DESERT_HILLS,
            settings.getBiomeProperty(SettingTags.DESERT_HILLS)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.FOREST_HILLS,
            settings.getBiomeProperty(SettingTags.FOREST_HILLS)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.TAIGA_HILLS,
            settings.getBiomeProperty(SettingTags.TAIGA_HILLS)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.EXTREME_HILLS_EDGE,
            settings.getBiomeProperty(SettingTags.EXTREME_HILLS_EDGE)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.JUNGLE,
            settings.getBiomeProperty(SettingTags.JUNGLE)
        );
        biomeMap.put(
            kaptainwutax.biomeutils.biome.Biomes.JUNGLE_HILLS,
            settings.getBiomeProperty(SettingTags.JUNGLE_HILLS)
        );
        
        return biomeMap;
    }
}
