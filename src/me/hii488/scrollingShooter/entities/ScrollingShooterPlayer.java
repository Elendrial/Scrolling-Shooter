package me.hii488.scrollingShooter.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import me.hii488.gameWorld.World;
import me.hii488.general.Position;
import me.hii488.objects.entities.Player;
import me.hii488.scrollingShooter.Initilisation;

public class ScrollingShooterPlayer extends Player{
	
	public int cooldown = 0;
	public int lives = 3;
	
	@Override
	public void setup() {
		this.textureName = "player.png";
		super.setup();
		this.speed = 6;
	}
	
	@Override
	public void onLoad(){
		this.position = new Position(World.mainWindow.width/2, World.mainWindow.height/2);
	}
	
	@Override
	public void updateOnTick(){
		super.updateOnTick();
		if(cooldown > 0) cooldown -= 1;
		if(cooldown < 0) cooldown = 0;
	}
	
	public void keyDown(KeyEvent arg0){
		super.keyDown(arg0);
		
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE && cooldown == 0){
			shoot();
		}
		
		Initilisation.gameController.keyDown(arg0);
	}
	
	
	@Override
	public void render(Graphics g){
		if(World.currentWorldContainerID == Initilisation.levelContainer.ID){
			super.render(g);
		}
		if(World.isPaused){
			Color c = g.getColor();
			g.setColor(Color.WHITE);
			Font f = g.getFont();
			g.setFont(Font.decode(Font.MONOSPACED + "-24"));
			g.drawString("PRESS P TO UNPAUSE", World.mainWindow.width/2-125, World.mainWindow.height/2-40);
			g.setFont(f);
			g.setColor(c);
		}
		
	}
	
	
	public void shoot(){
		Bullet b = new Bullet();
		b.shooter = this;
		b.position = this.position.clone();
		b.position.addToLocation(this.currentTexture.getWidth()/2, -this.currentTexture.getHeight());
		b.setup();
		World.getCurrentWorldContainer().addEntity(b);
		cooldown = 15;
	}
	
	public void isHit(Bullet b){
		this.lives--;
		if(lives <= 0){
			Initilisation.gameController.endGame();
			return;
		}
	}
	
}
