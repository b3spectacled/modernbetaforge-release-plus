package mod.bespectacled.modernbetareleaseplus;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kaptainwutax.mcutils.version.MCVersion;
import mod.bespectacled.modernbetaforge.api.property.BiomeProperty;
import mod.bespectacled.modernbetaforge.api.property.ListProperty;
import mod.bespectacled.modernbetaforge.api.registry.ModernBetaRegistries;
import mod.bespectacled.modernbetareleaseplus.world.biome.BiomeTags;
import mod.bespectacled.modernbetareleaseplus.world.biome.source.ReleasePlusBiomeSource;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = ModernBetaReleasePlus.MODID,
    name = ModernBetaReleasePlus.NAME,
    version = ModernBetaReleasePlus.VERSION,
    acceptedMinecraftVersions = ModernBetaReleasePlus.MCVERSION,
    dependencies = ModernBetaReleasePlus.MODERN_BETA_MODID
)
public class ModernBetaReleasePlus {
    public static final String MODID = "modernbetareleaseplus";
    public static final String NAME = "Modern Beta Release Plus";
    public static final String VERSION = "1.4.0.0";
    public static final String MCVERSION = "1.12.2";
    public static final String MODERN_BETA_MODID = "required-after:modernbetaforge@[1.8.0.0,1.9.0.0);";

    private static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static void log(Level level, String message) {
        LOGGER.log(level, "{}", message);
    }
    
    public static ResourceLocation createRegistryKey(String name) {
        return new ResourceLocation(MODID, name);
    }
    
    private static BiomeProperty createBiomeProperty(ResourceLocation biomeKey) {
        return new BiomeProperty(biomeKey);
    }
    
    @SidedProxy(
        clientSide = "mod.bespectacled.modernbetareleaseplus.ModernBetaReleasePlusClientProxy",
        serverSide = "mod.bespectacled.modernbetareleaseplus.ModernBetaReleasePlusServerProxy"
    )
    public static ModernBetaReleasePlusProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) { }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModernBetaRegistries.PROPERTY.register(SettingTags.GENERATOR_VERSION, new ListProperty(
            MCVersion.vb1_8_1.name,
            new String[] {
                MCVersion.vb1_8_1.name,
                MCVersion.v1_0.name,
                MCVersion.v1_1.name,
                MCVersion.v1_6_4.name
            }
        ));
        
        ModernBetaRegistries.PROPERTY.register(SettingTags.OCEAN, createBiomeProperty(BiomeTags.OCEAN));
        ModernBetaRegistries.PROPERTY.register(SettingTags.PLAINS, createBiomeProperty(BiomeTags.PLAINS));
        ModernBetaRegistries.PROPERTY.register(SettingTags.DESERT, createBiomeProperty(BiomeTags.DESERT));
        ModernBetaRegistries.PROPERTY.register(SettingTags.EXTREME_HILLS, createBiomeProperty(BiomeTags.EXTREME_HILLS));
        ModernBetaRegistries.PROPERTY.register(SettingTags.FOREST, createBiomeProperty(BiomeTags.FOREST));
        ModernBetaRegistries.PROPERTY.register(SettingTags.TAIGA, createBiomeProperty(BiomeTags.TAIGA));
        ModernBetaRegistries.PROPERTY.register(SettingTags.SWAMPLAND, createBiomeProperty(BiomeTags.SWAMPLAND));
        ModernBetaRegistries.PROPERTY.register(SettingTags.RIVER, createBiomeProperty(BiomeTags.RIVER));
        ModernBetaRegistries.PROPERTY.register(SettingTags.FROZEN_OCEAN, createBiomeProperty(BiomeTags.FROZEN_OCEAN));
        ModernBetaRegistries.PROPERTY.register(SettingTags.FROZEN_RIVER, createBiomeProperty(BiomeTags.FROZEN_RIVER));
        ModernBetaRegistries.PROPERTY.register(SettingTags.ICE_PLAINS, createBiomeProperty(BiomeTags.ICE_PLAINS));
        ModernBetaRegistries.PROPERTY.register(SettingTags.ICE_MOUNTAINS, createBiomeProperty(BiomeTags.ICE_MOUNTAINS));
        ModernBetaRegistries.PROPERTY.register(SettingTags.MUSHROOM_ISLAND, createBiomeProperty(BiomeTags.MUSHROOM_ISLAND));
        ModernBetaRegistries.PROPERTY.register(SettingTags.MUSHROOM_ISLAND_SHORE, createBiomeProperty(BiomeTags.MUSHROOM_ISLAND_SHORE));
        ModernBetaRegistries.PROPERTY.register(SettingTags.BEACH, createBiomeProperty(BiomeTags.BEACH));
        ModernBetaRegistries.PROPERTY.register(SettingTags.DESERT_HILLS, createBiomeProperty(BiomeTags.DESERT_HILLS));
        ModernBetaRegistries.PROPERTY.register(SettingTags.FOREST_HILLS, createBiomeProperty(BiomeTags.FOREST_HILLS));
        ModernBetaRegistries.PROPERTY.register(SettingTags.TAIGA_HILLS, createBiomeProperty(BiomeTags.TAIGA_HILLS));
        ModernBetaRegistries.PROPERTY.register(SettingTags.EXTREME_HILLS_EDGE, createBiomeProperty(BiomeTags.EXTREME_HILLS_EDGE));
        ModernBetaRegistries.PROPERTY.register(SettingTags.JUNGLE, createBiomeProperty(BiomeTags.JUNGLE));
        ModernBetaRegistries.PROPERTY.register(SettingTags.JUNGLE_HILLS, createBiomeProperty(BiomeTags.JUNGLE_HILLS));
        
        ModernBetaRegistries.BIOME_SOURCE.register(SettingTags.BIOME_SOURCE, ReleasePlusBiomeSource::new);
        
        proxy.init();
    }
    
}
