package com.cavetale.blank;

import com.cavetale.blank.event.BlankBiomeProviderEvent;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;

public final class BlankBiomeProvider extends BiomeProvider {
    @Getter @Setter private Biome singleBiome = null;

    @Override
    public Biome getBiome(WorldInfo worldInfo, int x, int y, int z) {
        if (singleBiome != null) {
            return singleBiome;
        } else {
            final BlankBiomeProviderEvent event = new BlankBiomeProviderEvent(this, worldInfo, x, y, z);
            event.callEvent();
            return event.getBiome();
        }
    }

    @Override
    public List<Biome> getBiomes(WorldInfo worldInfo) {
        if (singleBiome != null) {
            return List.of(singleBiome);
        } else {
            final BlankBiomeProviderEvent event = new BlankBiomeProviderEvent(this, worldInfo, 0, 0, 0);
            event.callEvent();
            return event.getBiomes();
        }
    }
}
