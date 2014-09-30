package com.zandor300.portalplace.listener.block;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPhysicsEvent;

import com.zandor300.portalplace.PortalPlace;
import com.zandor300.portalplace.listener.PCListener;

public class BlockPhysics extends PCListener {

	public BlockPhysics(PortalPlace pl) {
		super(pl);
	}

	@EventHandler
	public void onBlockPhysics(BlockPhysicsEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (event.getBlock().getType().equals(Material.PORTAL)) {
			event.setCancelled(true);
		}
		if (event.getChangedType().equals(Material.PORTAL)) {
			event.setCancelled(true);
		}
	}
}
