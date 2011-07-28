package com.seriousminecraft.ResurrectionSickness.player;
/**
 * Represents a ResurrectionSickness Player
 */
import com.seriousminecraft.ResurrectionSickness.util.RSConfig;

public class RSPlayer {
	
	private long combatTimer;
	private int deathCounter;
	
	public RSPlayer(){
		combatTimer = 0;
		deathCounter = 0;
	}
	
	public boolean canFight(){
		if (RSConfig.Penalty)
			return combatTimer + RSConfig.PenaltyTime*1000 < System.currentTimeMillis() ? true : false; 
		return true;
	}
	
	private void increaseCounter(){
		deathCounter += deathCounter < RSConfig.deathCount ? 1 : 0;
	}
	
	private void setTimer(){
		combatTimer = System.currentTimeMillis();
	}
	
	public int getRemainingTime(){
		return (int) (((combatTimer + RSConfig.PenaltyTime*1000) - System.currentTimeMillis()) / 1000);
	}
	
	public void playerDied(){
		increaseCounter();
		setTimer();
	}

	public void playerRespawned(){
		deathCounter -= (combatTimer + RSConfig.sickReset*1000) < System.currentTimeMillis() ? RSConfig.deathCount : 0;
	}
	
	public boolean isSick(){
		if (RSConfig.enableSickness)
			return deathCounter >= RSConfig.deathCount ? true : false;
		return false;
	}

}
