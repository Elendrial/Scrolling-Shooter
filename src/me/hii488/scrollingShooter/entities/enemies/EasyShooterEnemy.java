package me.hii488.scrollingShooter.entities.enemies;

import java.util.ArrayList;

import me.hii488.gameWorld.World;
import me.hii488.helpers.EntityHelper;
import me.hii488.objects.entities.GeneralEntity;
import me.hii488.objects.entities.Player;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.entities.Bullet;
import me.hii488.scrollingShooter.entities.ScrollingShooterPlayer;

public class EasyShooterEnemy extends GeneralEnemyEntity {
	
	public int movementTimer = 0;
	
	public EasyShooterEnemy(){}
	
	public EasyShooterEnemy(EasyShooterEnemy e) {
		super(e);
	}
	
	@Override
	public void setup() {
		textureName = "easyShootingEnemy.png";
		this.health = 1 + (int)Math.floor(Initilisation.gameController.level/2);
		this.randTickChance = 1f/300f;
		super.setup();
	}
	
	public EasyShooterEnemy clone(){
		return new EasyShooterEnemy(this);
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
		b.speed = -b.speed -6 + World.rand.nextInt(6);
		b.setup();
		World.getCurrentWorldContainer().addEntity(b);
	}
	
	public void isShot(Bullet b){
		if(b.shooter instanceof Player){
			this.destroy();
			Initilisation.gameController.score += 40 + 15 * Initilisation.gameController.level;
		}
		super.isShot(b);
	}
	
}
