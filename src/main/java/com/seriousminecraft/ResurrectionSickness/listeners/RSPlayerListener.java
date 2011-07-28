package com.seriousminecraft.ResurrectionSickness.listeners;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.seriousminecraft.ResurrectionSickness.Plugin;
import com.seriousminecraft.ResurrectionSickness.player.PlayerSickness;

public class RSPlayerListener extends PlayerListener{
	
	Plugin plugin;
	
	public RSPlayerListener(Plugin plugin){
		this.plugin = plugin;
	}
	
	
	/**
	 * When a player respawns -> check if they are under penalty
	 * If they are -> Damage them
	 */
	public void onPlayerRespawn(PlayerRespawnEvent e){
		if(Plugin.sicknessHandler.getPlayer(e.getPlayer()).isSick())
			plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new PlayerSickness(e.getPlayer()));
	}
	
}
