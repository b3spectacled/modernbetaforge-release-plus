package mod.bespectacled.modernbetareleaseplus.world.biome.source;

import kaptainwutax.biomeutils.source.OverworldBiomeSource;
import kaptainwutax.mcutils.version.MCVersion;
import mod.bespectacled.modernbetaforge.api.world.biome.source.BiomeSource;
import mod.bespectacled.modernbetaforge.api.world.biome.source.NoiseBiomeSource;
import mod.bespectacled.modernbetaforge.world.setting.ModernBetaGeneratorSettings;
import mod.bespectacled.modernbetareleaseplus.world.biome.BiomeMap;
import mod.bespectacled.modernbetareleaseplus.world.biome.climate.SimpleClimateSampler;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ReleasePlusBiomeSource extends BiomeSource implements NoiseBiomeSource {
    private final MCVersion version;
    private final BiomeMap biomeMap;
    private final int biomeSize;
    private final long seed;
    
    private final SimpleClimateSampler deepOceanSampler;
    private final boolean useDeepOceans;
    private final float deepOceanChance;
    private final float deepOceanNoiseScale;
    
    private kaptainwutax.biomeutils.source.BiomeSource biomeSource;
    
    public ReleasePlusBiomeSource(long seed, ModernBetaGeneratorSettings settings) {
        super(seed, settings);
        
        MCVersion version = MCVersion.fromString(settings.getListProperty(SettingTags.GENERATOR_VERSION));
        if (version.isOlderThan(MCVersion.vb1_8_1))
            version = MCVersion.vb1_8_1;
        if (version.isNewerThan(MCVersion.v1_6_4))
            version = MCVersion.v1_6_4;
        
        this.version = version;
        this.biomeMap = new BiomeMap(settings);
        this.biomeSize = settings.getIntProperty(SettingTags.BIOME_SIZE);
        this.seed = seed;
        
        this.deepOceanSampler = new SimpleClimateSampler(seed, 4397L, 48821L);
        this.useDeepOceans = settings.getBooleanProperty(SettingTags.USE_DEEP_OCEANS);
        this.deepOceanChance = settings.getFloatProperty(SettingTags.DEEP_OCEAN_CHANCE);
        this.deepOceanNoiseScale = settings.getFloatProperty(SettingTags.DEEP_OCEAN_NOISE_SCALE);
    }

    @Override
    public Biome getBiome(int x, int z) {
        if (this.biomeSource == null) {
            this.biomeSource = new OverworldBiomeSource(this.version, this.seed, this.biomeSize, this.biomeSize);
        }
        
        Biome biome = this.biomeMap.getBiome(this.biomeSource.getBiome(x, 0, z));
        if (this.useDeepOceans && this.isValidOcean(x, z, biome) && this.isDeepOcean(x, z)) {
            biome = Biomes.DEEP_OCEAN;
        }
        
        return biome;
    }
    
    private boolean isValidOcean(int x, int z, Biome biome) {
        return BiomeDictionary.hasType(biome, Type.OCEAN) && !BiomeDictionary.hasType(biome, Type.COLD);
    }
    
    private boolean isDeepOcean(int x, int z) {
        double scaledX = x * this.deepOceanNoiseScale;
        double scaledZ = z * this.deepOceanNoiseScale;
        
        if (this.deepOceanChance <= 0.0) {
            return false;
        }

        return this.deepOceanChance >= 1.0 || this.deepOceanSampler.sample(scaledX, scaledZ) <= this.deepOceanChance;
    }
}
