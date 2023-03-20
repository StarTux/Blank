package com.cavetale.blank.event;

import com.cavetale.blank.BlankBiomeProvider;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.generator.WorldInfo;

@Getter
public final class BlankBiomeProviderEvent extends Event {
    private final BlankBiomeProvider biomeProvider;
    private final WorldInfo worldInfo;
    private final int x;
    private final int y;
    private final int z;
    @Setter private Biome biome = Biome.THE_VOID;
    @Setter private List<Biome> biomes = List.of(Biome.THE_VOID);

    public BlankBiomeProviderEvent(final BlankBiomeProvider biomeProvider,
                                   final WorldInfo worldInfo, final int x, final int y, final int z) {
        super(!Bukkit.isPrimaryThread());
        this.biomeProvider = biomeProvider;
        this.worldInfo = worldInfo;
        this.x = x;
        this.y = y;
        this.z = z;
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
