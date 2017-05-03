package me.hii488.scrollingShooter;

import me.hii488.gameWorld.World;
import me.hii488.general.Settings;

public class ScrollingShooter {
	
	public static void main(String[] args){
		
		Initilisation.gameSetup();
		
		Settings.Logging.tpsPrinter = true;
	//	Settings.Logging.debug = true;
		
		World.startGame("Scrolling Shooter", 500, 800);
	}
}
