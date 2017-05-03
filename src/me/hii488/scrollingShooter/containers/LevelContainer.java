package me.hii488.scrollingShooter.containers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import me.hii488.gameWorld.World;
import me.hii488.gameWorld.baseTypes.GeneralWorldContainer;
import me.hii488.general.Settings;
import me.hii488.helpers.TextureHelper;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.entities.ScrollingShooterPlayer;

public class LevelContainer extends GeneralWorldContainer{
	
	public static BufferedImage heartIcon;
	
	public void setup() {
		super.setup();
		this.alwaysTicks = false;
		this.grid.setupGrid(World.mainWindow.width/16, World.mainWindow.height/16);

		heartIcon = TextureHelper.loadTexture("textures/icon/", "heart.png", this);
	}
	
	public void onLoad(){
		setupLevel();
		super.onLoad();
	}
	
	public void setupLevel(){
		this.clear();
		setup = true;
	}
	
	public void render(Graphics g){
		super.render(g);
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("Current Score: " + Initilisation.gameController.score, 5, 10);
		
		if(Settings.WorldSettings.debug) g.drawString("Wave: " + Initilisation.enemyLogic.wavesThisLevel + 1, 5, World.mainWindow.height-20);
		
		g.drawString("Lives Remaining: ", 7, World.mainWindow.height-7);
		for(int i = 0; i < ((ScrollingShooterPlayer)World.player).lives; i++) g.drawImage(heartIcon, 107 + i*(heartIcon.getWidth()+5), World.mainWindow.height-17, null);
		
		g.setColor(c);
	}
	
	public void keyPressed(KeyEvent arg0) {
		super.keyPressed(arg0);
		if(arg0.getKeyChar() == 'P' || arg0.getKeyChar() == 'p') World.isPaused = !World.isPaused;
		if(World.isPaused && (arg0.getKeyChar() == 'M' || arg0.getKeyChar() == 'm')) Initilisation.gameController.endGame();
	}
	
}
