package me.hii488.scrollingShooter.containers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import me.hii488.gameWorld.World;
import me.hii488.gameWorld.baseTypes.GeneralWorldContainer;
import me.hii488.saveSystem.FileIO;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.other.Score;

public class MainMenuContainer extends GeneralWorldContainer{
	
	public ArrayList<Score> scores = new ArrayList<Score>();
	
	public void setup() {
		super.setup();
		this.alwaysTicks = false;
		this.grid.setupGrid(World.mainWindow.width/16, World.mainWindow.height/16);
	//	buttonInit();
	}
	
	public void onLoad(){
		super.onLoad();
		scores.clear();
		String[] data = FileIO.readFile("highscores.SS").split("-");
		
		if(data.length > 1) for(int i = 0; i < data.length-1; i++) scores.add(new Score(data[i].split(":")[0], Integer.parseInt(data[i].split(":")[1])));
	

		Collections.sort(scores, new Score());
		Collections.reverse(scores);
		
	}
	
	public void render(Graphics g){
		super.render(g);
		
		Color c = g.getColor();
		g.setColor(Color.white);
		Font f = g.getFont();
		g.setFont(Font.decode(Font.MONOSPACED + "-24"));
		
		g.drawString("Press Anything To Start", World.mainWindow.width/2 - 160, 80);
		
		g.setFont(Font.decode(Font.MONOSPACED + "-20"));
		g.drawString("---Highscores---", World.mainWindow.width/2 - 95, 130);
		
		for(int i = 0; i < scores.size(); i++)
			g.drawString(scores.get(i).name + " : " + scores.get(i).score, World.mainWindow.width/2 -scores.get(i).name.length()*12, 170 + i * 30);

		
		g.setFont(f);
		g.setColor(c);
	}
	
	
	public void keyPressed(KeyEvent arg0) {Initilisation.gameController.startGame();}
	
	
}
