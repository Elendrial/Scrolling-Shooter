package me.hii488.scrollingShooter.entities.enemies;

import java.util.ArrayList;

import me.hii488.helpers.EntityHelper;
import me.hii488.objects.entities.GeneralEntity;
import me.hii488.objects.entities.Player;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.entities.Bullet;
import me.hii488.scrollingShooter.entities.ScrollingShooterPlayer;

public class StandardEnemy extends GeneralEnemyEntity {
	
	public int movementType = 0;
	
	public StandardEnemy(){}
	
	public StandardEnemy(StandardEnemy e) {
		super(e);
	}
	
	@Override
	public void setup() {
		textureName = "standardEnemy.png";
		this.health = 1;
		super.setup();
	}
	
	public StandardEnemy clone(){
		return new StandardEnemy(this);
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
	
	
	public void isShot(Bullet b){
		if(b.shooter instanceof Player){
			this.destroy();
			Initilisation.gameController.score += 30 + 10 * Initilisation.gameController.level;
		}
		super.isShot(b);
	}
	
}
