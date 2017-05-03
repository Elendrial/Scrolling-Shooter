package me.hii488.scrollingShooter.additionalTickers;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import me.hii488.gameWorld.World;
import me.hii488.gameWorld.tickControl.ITickable;
import me.hii488.gameWorld.tickControl.TickController;
import me.hii488.general.Settings;
import me.hii488.saveSystem.FileIO;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.entities.ScrollingShooterPlayer;

public class GameController implements ITickable{
	
	public int level = 0;
	public int score = 0;
	
	@Override
	public boolean alwaysTicks() {return false;}

	@Override
	public float randTickChance() {return 0;}

	@Override
	public void updateOnTick() {}

	@Override
	public void updateOnSec() {
		if(TickController.actualTPS != Settings.WorldSettings.TargetTPS) TickController.actualTPS = Settings.WorldSettings.TargetTPS;
	}

	@Override
	public void updateOnRandTick() {}

	
	public void keyDown(KeyEvent e){}
	
	
	public void startGame(){
		level = 0;
		score = 0;
		((ScrollingShooterPlayer)World.player).lives = 3;
		
		Initilisation.enemyLogic.waveProgress = 140;
		Initilisation.enemyLogic.waveType = 0;
		Initilisation.enemyLogic.wavesThisLevel = 0;
		Initilisation.enemyLogic.general = 0;
		
		World.Containers.loadNewContainer(Initilisation.levelContainer.ID);
		
		TickController.actualTPS = 30;
	}
	
	public void endGame(){
		World.getCurrentWorldContainer().clear();
		World.isPaused = true; 
		String name = JOptionPane.showInputDialog("What is your name?").replaceAll(":", " ").replaceAll("-", " ").trim();
		FileIO.writeFile("highscores.SS", FileIO.readFile("highscores.SS") + name + ":" + score + "-\n");
		World.isPaused = false;
		World.Containers.loadNewContainer(Initilisation.menuContainer.ID);
	}
	
	
	
}
