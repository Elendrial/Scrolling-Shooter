package me.hii488.scrollingShooter.entities.enemies;

import java.util.ArrayList;

import me.hii488.gameWorld.World;
import me.hii488.helpers.EntityHelper;
import me.hii488.objects.entities.GeneralEntity;
import me.hii488.objects.entities.Player;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.entities.Bullet;
import me.hii488.scrollingShooter.entities.ScrollingShooterPlayer;

public class HardShooterEnemy extends GeneralEnemyEntity {
	
	public int movementTimer = 0;
		
	public HardShooterEnemy(){}
	
	public HardShooterEnemy(HardShooterEnemy e) {
		super(e);
	}
	
	@Override
	public void setup() {
		textureName = "hardShootingEnemy.png";
		this.health = 2 + (int)Math.floor(Initilisation.gameController.level/2);
		this.randTickChance = 1f/150f;
		super.setup();
	}
	
	public HardShooterEnemy clone(){
		return new HardShooterEnemy(this);
	}
	
	@Override
	public void updateOnTick(){
		super.updateOnTick();
		if(notDestroyed){
			ArrayList<GeneralEntity> collidingWith = EntityHelper.getCollidingEntities(this);
			for(GeneralEntity e : collidingWith){
				if(e instanceof ScrollingShooterPlayer) ((ScrollingShooterPlayer)e).isHit(null);
			}
		}
	}
	
	@Override
	public void updateOnRandTick(){
		Bullet b = new Bullet();
		b.shooter = this;
		b.position = this.position.clone();
		b.position.addToLocation(this.currentTexture.getWidth()/2, this.currentTexture.getHeight());
		b.speed = -b.speed -7 + World.rand.nextInt(6);
		b.setup();
		World.getCurrentWorldContainer().addEntity(b);
	}
	
	public void isShot(Bullet b){
		if(b.shooter instanceof Player){
			this.health--;
			if(this.health == 0){
				this.destroy();
				Initilisation.gameController.score += 60 + 20 * Initilisation.gameController.level;
			}
		}
		super.isShot(b);
	}
	
}
