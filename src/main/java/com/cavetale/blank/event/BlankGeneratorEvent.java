package com.cavetale.blank.event;

import com.cavetale.blank.BlankGenerator;
import com.cavetale.blank.GeneratorPhase;
import java.util.Random;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.generator.WorldInfo;

@Getter
public final class BlankGeneratorEvent extends Event {
    private final BlankGenerator generator;
    private final WorldInfo worldInfo;
    private final Random random;
    private final int x;
    private final int z;
    private final ChunkData chunkData;
    private final GeneratorPhase phase;

    public BlankGeneratorEvent(final BlankGenerator generator,
                               final WorldInfo worldInfo,
                               final Random random,
                               final int x,
                               final int z,
                               final ChunkData chunkData,
                               final GeneratorPhase phase) {
        super(!Bukkit.isPrimaryThread());
        this.generator = generator;
        this.worldInfo = worldInfo;
        this.random = random;
        this.x = x;
        this.z = z;
        this.chunkData = chunkData;
        this.phase = phase;
    }

    public String getWorldName() {
        return worldInfo.getName();
    }

    /**
     * Required by Event.
     */
    @Getter private static HandlerList handlerList = new HandlerList();

    /**
     * Required by Event.
     */
    @Override public HandlerList getHandlers() {
        return handlerList;
    }
}
