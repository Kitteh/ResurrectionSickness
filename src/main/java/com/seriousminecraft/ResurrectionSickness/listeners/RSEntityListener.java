package com.seriousminecraft.ResurrectionSickness.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;

import com.seriousminecraft.ResurrectionSickness.Plugin;
import com.seriousminecraft.ResurrectionSickness.player.RSPlayer;
import com.seriousminecraft.ResurrectionSickness.util.Messenger;

public class RSEntityListener extends EntityListener{
	
	/**
	 * When a player dies, increase there death counter && Set there PVP timer
	 */
	public void onEntityDeath(EntityDeathEvent e){
		if (e.getEntity() instanceof Player){
			Plugin.sicknessHandler.getPlayer((Player)e.getEntity()).playerDied();
			return;
		}
	}
	
	/**
	 * When a player attacks another player, check if they're allowed to 
	 * before calculating damage
	 * (PVP Restrictions after death)
	 */
	public void onEntityDamage(EntityDamageEvent e){
		if (e instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent edee = (EntityDamageByEntityEvent) e;
			//Check if Event is PVP
			if (edee.getDamager() instanceof Player && edee.getEntity() instanceof Player){
				RSPlayer p = Plugin.sicknessHandler.getPlayer((Player) edee.getDamager());
				if(!p.canFight()){
					Messenger.messagePlayer((Player) edee.getDamager(), 
							"You must wait " + p.getRemainingTime() + " seconds before engaing combat");
					edee.setDamage(0);
					return;
				}
			}
		}
	}
}
