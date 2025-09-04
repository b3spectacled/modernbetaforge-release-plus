package mod.bespectacled.modernbetareleaseplus.datafix;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import mod.bespectacled.modernbetaforge.util.NbtTags;
import net.minecraft.util.JsonUtils;

public class DataFixers {
    public static JsonElement fixBiomeSize(JsonObject jsonObject) {
        return new JsonPrimitive(JsonUtils.getInt(jsonObject, NbtTags.BIOME_SIZE, 4));
    }
}
