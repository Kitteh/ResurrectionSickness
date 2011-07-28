package com.seriousminecraft.ResurrectionSickness;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.seriousminecraft.ResurrectionSickness.handlers.SicknessHandler;
import com.seriousminecraft.ResurrectionSickness.listeners.RSEntityListener;
import com.seriousminecraft.ResurrectionSickness.listeners.RSPlayerListener;
import com.seriousminecraft.ResurrectionSickness.util.ConfigLoader;
import com.seriousminecraft.ResurrectionSickness.util.Messenger;

/**
 * This plugin enables PVP restrictions within Minecraft.
 * Players may not attack other players after dying until the timer has expired
 * Players who die too much will respawn with less health
 * @author jam
 *
 */
public class Plugin extends JavaPlugin{
	
	public static final SicknessHandler sicknessHandler = new SicknessHandler();

	public void onEnable(){
		
		PluginManager pm = this.getServer().getPluginManager();
		RSPlayerListener playerListener = new RSPlayerListener(this);
		RSEntityListener entityListener = new RSEntityListener();
		
		Messenger.setupName("PVP");
		
		/* Load Configuration */
		ConfigLoader configLoader = new ConfigLoader(this);
		configLoader.newConfig("plugins/" + this.getDescription().getName() + "/", "config.yml");
		configLoader.setupRSConfig();
		
		/* Register Events */
		pm.registerEvent(Type.PLAYER_RESPAWN, playerListener, Priority.Monitor, this);
		
		pm.registerEvent(Type.ENTITY_DAMAGE, entityListener, Priority.High, this);
		pm.registerEvent(Type.ENTITY_DEATH, entityListener, Priority.Monitor, this);
		
		
		/* Print welcome message */
		Messenger.consoleMessage("Version : " + this.getDescription().getVersion() + " Enabled");
	}

	public void onDisable(){
		
	}

}
