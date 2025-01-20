package mod.bespectacled.modernbetareleaseplus.world.biome.source;

import kaptainwutax.biomeutils.source.OverworldBiomeSource;
import kaptainwutax.mcutils.version.MCVersion;
import mod.bespectacled.modernbetaforge.api.world.biome.source.BiomeSource;
import mod.bespectacled.modernbetaforge.api.world.biome.source.NoiseBiomeSource;
import mod.bespectacled.modernbetaforge.world.setting.ModernBetaGeneratorSettings;
import mod.bespectacled.modernbetareleaseplus.world.biome.BiomeMap;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;
import net.minecraft.world.biome.Biome;

public class ReleasePlusBiomeSource extends BiomeSource implements NoiseBiomeSource {
    private final MCVersion version;
    private final long seed;
    private final ModernBetaGeneratorSettings settings;
    private final BiomeMap biomeMap;
    
    private kaptainwutax.biomeutils.source.BiomeSource biomeSource;
    
    public ReleasePlusBiomeSource(long seed, ModernBetaGeneratorSettings settings) {
        super(seed, settings);
        
        MCVersion version = MCVersion.fromString(settings.getListProperty(SettingTags.GENERATOR_VERSION));
        if (version.isOlderThan(MCVersion.vb1_8_1))
            version = MCVersion.vb1_8_1;
        if (version.isNewerThan(MCVersion.v1_6_4))
            version = MCVersion.v1_6_4;
        
        this.version = version;
        this.seed = seed;
        this.settings = settings;
        this.biomeMap = new BiomeMap(settings);
        
        // Lazy init in getBiome
        this.biomeSource = null; 
    }

    @Override
    public Biome getBiome(int x, int z) {
        if (this.biomeSource == null) {
            this.biomeSource = new OverworldBiomeSource(this.version, this.seed, this.settings.biomeSize, this.settings.riverSize);
        }
        
        return this.biomeMap.getBiome(this.biomeSource.getBiome(x, 0, z));
    }
}
