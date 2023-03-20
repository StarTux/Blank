package com.cavetale.blank;

import org.bukkit.plugin.java.JavaPlugin;

public final class BlankPlugin extends JavaPlugin {
    protected static BlankPlugin instance;

    public BlankPlugin() {
        instance = this;
    }

    @Override
    public void onEnable() { }

    @Override
    public void onDisable() { }

    @Override
    public BlankGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new BlankGenerator();
    }

    @Override
    public BlankBiomeProvider getDefaultBiomeProvider(String worldName, String id) {
        return new BlankBiomeProvider();
    }
}
