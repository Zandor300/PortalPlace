package com.zandor300.portalplace;

import java.io.IOException;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import com.zandor300.portalplace.listener.block.BlockPhysics;
import com.zandor300.portalplace.utilities.Chat;

public class PortalPlace extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Chat.init(this);

		Chat.sendConsoleMessage("Setting up events...");
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new BlockPhysics(this), this);
		Chat.sendConsoleMessage("Setting up events done!");

		Chat.sendConsoleMessage("Sending stats to MCStats...");
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
			Chat.sendConsoleMessage("Sending stats to MCStats done!");
		} catch (IOException e) {
			Chat.sendConsoleMessage("Sending stats to MCStats failed!");
		}

		Chat.sendConsoleMessage("PortalPlace is enabled!");
	}

	@Override
	public void onDisable() {
		Chat.sendConsoleMessage("PortalPlace is disabled!");
	}
}
