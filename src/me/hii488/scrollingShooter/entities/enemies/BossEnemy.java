package me.hii488.scrollingShooter.entities.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import me.hii488.gameWorld.World;
import me.hii488.general.Position;
import me.hii488.general.Settings;
import me.hii488.helpers.EntityHelper;
import me.hii488.objects.entities.GeneralEntity;
import me.hii488.objects.entities.Player;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.additionalTickers.LevelLogic;
import me.hii488.scrollingShooter.entities.BossBullet;
import me.hii488.scrollingShooter.entities.Bullet;
import me.hii488.scrollingShooter.entities.ScrollingShooterPlayer;

public class BossEnemy extends GeneralEnemyEntity {
	
	public BossEnemy(){}
	
	public BossEnemy(BossEnemy e) {
		super(e);
		movementType = -1;
		this.bossState = e.bossState;
		this.bossTimer = e.bossTimer;
		this.yoffset = e.yoffset;
	}
	
	@Override
	public void setup() {
		textureName = "bossEnemy.png";
		this.health = 60;
		super.setup();
		movementType = -1;
	}
	
	public BossEnemy clone(){
		return new BossEnemy(this);
	}
	
	
	
	public int bossState = 0; // -1 = entering, 0 = shooting at you, 1 = spawning random ships.
	public int bossTimer = 100;
	public int bossTextureAltenator = 0;
	
	@Override
	public void updateOnTick(){
		super.updateOnTick();
		if(notDestroyed){
			ArrayList<GeneralEntity> collidingWith = EntityHelper.getCollidingEntities(this);
			for(GeneralEntity e : collidingWith){
				if(e instanceof ScrollingShooterPlayer) ((ScrollingShooterPlayer)e).isHit(null);
			}
		}
		
		if(bossTextureAltenator == 0) bossTextureAltenator = 60;
		bossTextureAltenator--;
		
		if(bossState == -1){
			yoffset = -bossTimer;
			if(bossTimer <= 0){
				bossTimer = 100;
				bossState = 0;
				yoffset = 0;
			}
		}
		else{
			yoffset += (bossTextureAltenator < 30 ? -0.5 : 0.5);
		}
		
		
		// Boss Logic
		if(bossState == 0 && bossTimer == 0){
			doRandomShotSpread();
			bossTimer += World.rand.nextInt(30+this.health) + 10;
			if(this.health < 40 && this.health > 20){
				bossState = 1;
			}
		}
		
		if(bossState == 1 && bossTimer == 0){
			bossTimer += World.rand.nextInt(40) + 20;
			summonRandEnemy();
			if(this.health > 40 || this.health < 20){
				bossState = 0;
			}
		}
		
		if(bossTimer > 0) bossTimer--;
	}
	
	public void doRandomShotSpread(){
		final float f = World.rand.nextFloat();
		if(f < 1f/4f){
			for(int i =-4; i < 4; i++) {
				BossBullet b = new BossBullet();
				b.shooter = this;
				b.deltaPos.setLocation(i/3 + World.rand.nextInt(2)-1, 7);
				b.setup();
				b.position.setLocation((float) (World.mainWindow.width*(i+4.5)/8 + World.rand.nextInt(4)-2), this.currentTexture.getHeight() + b.currentTexture.getHeight() + 3);
				World.getCurrentWorldContainer().addEntity(b);
			}
			return;
		}
		if(f < 2f/4f){
			for(int i =-4; i < 4; i++) {
				BossBullet b = new BossBullet();
				b.shooter = this;
				b.deltaPos.setLocation(0, 7);
				b.setup();
				b.position.setLocation((float) (World.mainWindow.width*(i+4.5)/8 + World.rand.nextInt(4)-2), this.currentTexture.getHeight() + b.currentTexture.getHeight() + 3);
				World.getCurrentWorldContainer().addEntity(b);
			}
			return;
		}
		if(f < 3f/4f){
			for(int i =-8; i < 8; i++) {
				BossBullet b = new BossBullet();
				b.shooter = this;
				b.deltaPos.setLocation(0, 7);
				b.setup();
				b.position.setLocation((float) (World.mainWindow.width*(i+8.5)/18), this.currentTexture.getHeight() + b.currentTexture.getHeight() + 3);
				if(World.rand.nextFloat() > 0.17) World.getCurrentWorldContainer().addEntity(b);
			}
			return;
		}
		
		for(int i = -3; i < 4; i++){
			BossBullet b = new BossBullet();
			b.shooter = this;
			b.deltaPos.setLocation(0, 7);
			b.setup();
			b.position.setLocation(World.player.position.getAbsX() + i*(b.currentTexture.getWidth() + 2), this.currentTexture.getHeight() + b.currentTexture.getHeight() + 3);
			World.getCurrentWorldContainer().addEntity(b);
		}
	}
	
	public GeneralEnemyEntity ge;
	public void summonRandEnemy(){
		ge = LevelLogic.chooseRandomEnemy();
		if(ge instanceof StandardEnemy && World.rand.nextBoolean()) ge = LevelLogic.chooseRandomEnemy();
		
		ge.position = new Position(58, this.currentTexture.getHeight());
		ge.health = 1;
		ge.movementType = 6;
		
		World.getCurrentWorldContainer().addEntity(ge.clone());
		
		ge = LevelLogic.chooseRandomEnemy();
		if(ge instanceof StandardEnemy && World.rand.nextBoolean()) ge = LevelLogic.chooseRandomEnemy();
		
		ge.position = new Position(World.mainWindow.width - 58, this.currentTexture.getHeight());
		ge.health = 1;
		ge.movementType = 7;
		
		World.getCurrentWorldContainer().addEntity(ge.clone());
	}
	
	public float yoffset = 0;
	@Override
	public void render(Graphics g){
		currentTexture = textureImages[currentState];
		g.drawImage(currentTexture, position.getX(), (int) (position.getY() + yoffset), null);
		
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("Boss Health: ", 180, World.mainWindow.height- 7);
		g.fillRect(255, World.mainWindow.height-17, 64, 12);
		g.setColor(Color.red);
		g.fillRect(257, World.mainWindow.height-15, this.health, 8);
		
		if(Settings.Logging.debug || this.showCollisionBox){
			g.setColor(Color.red);
			g.drawRect(this.collisionBox.x, this.collisionBox.y, this.collisionBox.width, this.collisionBox.height);
		}
		
		g.setColor(c);
	}
	
	
	public void isShot(Bullet b){
		if(b.shooter instanceof Player){
			this.health--;
			if(this.health == 0){
				Initilisation.enemyLogic.waveProgress = -2;
				this.destroy();
				Initilisation.gameController.score += 500 + 100 * Initilisation.gameController.level;
			}
		}
		super.isShot(b);
	}
	
}
