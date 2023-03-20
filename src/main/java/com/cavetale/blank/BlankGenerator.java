package com.cavetale.blank;

import com.cavetale.blank.event.BlankGeneratorEvent;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import static com.cavetale.blank.GeneratorPhase.*;

@Getter
public final class BlankGenerator extends ChunkGenerator {
    @Override
    public boolean canSpawn(final World world, final int x, final int z) {
        return false;
    }

    @Setter private List<BlockPopulator> defaultBlockPopulators = List.of();

    @Override
    public List<BlockPopulator> getDefaultPopulators(final World world) {
        return defaultBlockPopulators;
    }

    @Override
    public Location getFixedSpawnLocation(final World world, final Random random) {
        return new Location(world, 255.5, 64.0, 255.5);
    }

    @Override
    public void generateNoise(WorldInfo worldInfo, Random random, int x, int z, ChunkData chunkData) {
        new BlankGeneratorEvent(this, worldInfo, random, x, z, chunkData, NOISE).callEvent();
    }

    @Override
    public void generateSurface(WorldInfo worldInfo, Random random, int x, int z, ChunkData chunkData) {
        new BlankGeneratorEvent(this, worldInfo, random, x, z, chunkData, SURFACE).callEvent();
    }

    @Override
    public void generateBedrock(WorldInfo worldInfo, Random random, int x, int z, ChunkData chunkData) {
        new BlankGeneratorEvent(this, worldInfo, random, x, z, chunkData, BEDROCK).callEvent();
    }

    @Override
    public void generateCaves(WorldInfo worldInfo, Random random, int x, int z, ChunkData chunkData) {
        new BlankGeneratorEvent(this, worldInfo, random, x, z, chunkData, CAVES).callEvent();
    }

    @Setter private boolean shouldGenerateNoise;

    @Override
    public boolean shouldGenerateNoise() {
        return shouldGenerateNoise;
    }

    @Setter private boolean shouldGenerateSurface;

    @Override
    public boolean shouldGenerateSurface() {
        return shouldGenerateSurface;
    }

    @Setter private boolean shouldGenerateCaves;

    @Override
    public boolean shouldGenerateCaves() {
        return shouldGenerateCaves;
    }

    @Setter private boolean shouldGenerateDecorations;

    @Override
    public boolean shouldGenerateDecorations() {
        return shouldGenerateDecorations;
    }

    @Setter private boolean shouldGenerateMobs;

    @Override
    public boolean shouldGenerateMobs() {
        return shouldGenerateMobs;
    }

    @Setter private boolean shouldGenerateStructures;

    @Override
    public boolean shouldGenerateStructures() {
        return shouldGenerateStructures;
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(WorldInfo worldInfo) {
        return new BlankBiomeProvider();
    }
}
