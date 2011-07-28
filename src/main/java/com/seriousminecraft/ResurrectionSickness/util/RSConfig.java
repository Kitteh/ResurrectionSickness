package com.seriousminecraft.ResurrectionSickness.util;

import org.bukkit.util.config.Configuration;

public class RSConfig {

	private static Configuration config;
	
	/* Plugin Info */
	public static double version;
	
	/* PVP settings */
	public static boolean Penalty;
	public static int PenaltyTime;
	
	/* Sickness Settings */
	public static boolean enableSickness;
	public static int deathCount;
	public static int healthOnSick;
	public static int sickReset;
	
	
	public static void setConfig(Configuration c){
		config = c;
	}
	
	public static void setupConfig(){
		config.load();
		
		Penalty = config.getBoolean("Settings.Penalty", true);
		PenaltyTime = config.getInt("Settings.PenaltyTime", 60);
		
		enableSickness = config.getBoolean("Settings.RessurectionSickness", true);
		deathCount = config.getInt("Settings.DeathCountForSick", 3);
		healthOnSick = config.getInt("Settings.HealthOnSick", 6);
		sickReset = config.getInt("Settings.ResetTime", 600);
	}
	
}
