package com.cavetale.blank;

import java.util.function.Consumer;
import net.kyori.adventure.util.TriState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

/**
 * Public access API.
 */
public final class Blank {
    /**
     * Create a world with the Blank generator.  Reasonable default
     * settings will be applied.  The callback can be used to modify
     * the WorldCreator prior to world creation.
     * @param name The world name
     * @param callback the callback
     * @return the world
     */
    public static World create(String name, Consumer<WorldCreator> callback) {
        final WorldCreator creator = new WorldCreator(name);
        creator.generator("Blank");
        creator.biomeProvider("Blank");
        creator.environment(World.Environment.NORMAL);
        creator.type(WorldType.FLAT);
        creator.generateStructures(false);
        creator.hardcore(false);
        creator.keepSpawnLoaded(TriState.FALSE);
        creator.seed(0L);
        if (callback != null) callback.accept(creator);
        return creator.createWorld();
    }

    private Blank() { }
}
