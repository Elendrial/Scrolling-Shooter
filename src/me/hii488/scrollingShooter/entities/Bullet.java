package me.hii488.scrollingShooter.entities;

import java.util.ArrayList;

import me.hii488.helpers.EntityHelper;
import me.hii488.objects.entities.GeneralEntity;
import me.hii488.scrollingShooter.entities.enemies.GeneralEnemyEntity;

public class Bullet extends GeneralEntity{
	
	public int speed = 13;
	public GeneralEntity shooter;
	
	@Override
	public void setup() {
		textureName = "bullet.png";
		super.setup();
	}
	
	
	@Override
	public void updateOnTick() {
		this.position.addToLocation(0, -speed);
		super.updateOnTick();
		if(notDestroyed){
			ArrayList<GeneralEntity> collidingWith = EntityHelper.getCollidingEntities(this);
			for(GeneralEntity e : collidingWith){
				if(this.shooter instanceof ScrollingShooterPlayer) if(e instanceof GeneralEnemyEntity){
					((GeneralEnemyEntity) e).isShot(this);
					if(notDestroyed)this.destroy();
				}
				if(e instanceof ScrollingShooterPlayer){
					((ScrollingShooterPlayer) e).isHit(this);
					if(notDestroyed)this.destroy();
				}
			}
			
		}
	}
	
}
