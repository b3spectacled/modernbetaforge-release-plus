package mod.bespectacled.modernbetareleaseplus.datafix;

import mod.bespectacled.modernbetaforge.api.datafix.DataFix;
import mod.bespectacled.modernbetaforge.api.datafix.ModDataFix;
import mod.bespectacled.modernbetareleaseplus.ModernBetaReleasePlus;
import mod.bespectacled.modernbetareleaseplus.world.setting.SettingTags;
import net.minecraft.util.ResourceLocation;

public class ModDataFixers {
    private static final int DATA_VERSION_V1_4_1_0 = 1410;
    
    public static final ResourceLocation BIOME_SIZE_FIX_KEY = ModernBetaReleasePlus.createRegistryKey("BIOME_SIZE_FIX");
    
    public static final ModDataFix BIOME_SIZE_FIX = ModDataFix.createModDataFix(
        DATA_VERSION_V1_4_1_0,
        new DataFix(SettingTags.BIOME_SIZE.toString(), DataFixers::fixBiomeSize)
    );
}
