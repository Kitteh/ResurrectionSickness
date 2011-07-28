package com.seriousminecraft.ResurrectionSickness.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class Messenger {
	Plugin plugin;
	private static String pluginName;
	public static String helpMessage;
	
	public static void consoleMessage(String s){
		System.out.println("[" + pluginName + "] " + s);
	}
	
	public static void setupName(String s){
		pluginName = s;
	}
	
	public static void messagePlayer(Player p, String s){
		p.sendMessage(prefixChat(ChatColor.WHITE + s));
	}
	
	private static String prefixChat(String s){
		return ChatColor.BLACK + "[" + ChatColor.DARK_RED + "PVP" + ChatColor.BLACK + "] " + s;
	}
	
	public static void noPermission(Player p){
		p.sendMessage(prefixChat(ChatColor.RED + "you do not have permission for that"));
	}
	
}
