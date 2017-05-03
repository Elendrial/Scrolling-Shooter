package me.hii488.scrollingShooter.entities;

import java.awt.Rectangle;
import java.util.ArrayList;

import me.hii488.general.Position;
import me.hii488.helpers.EntityHelper;
import me.hii488.objects.entities.GeneralEntity;
import me.hii488.scrollingShooter.entities.enemies.GeneralEnemyEntity;

public class BossBullet extends Bullet{
	
	public Position deltaPos = new Position(0,0);
	
	@Override
	public void setup() {
		textureName = "bossbullet.png";
		super.setup();
	}
	
	
	@Override
	public void updateOnTick() {
		this.position.addPosition(deltaPos);
		
		// 'Stolen' code from GeneralEntity to avoid Bullet Code.
		collisionBox = new Rectangle(position.getX(),position.getY(), currentTexture.getWidth(), currentTexture.getHeight());
		if(EntityHelper.isOutOfContainer(this)){
			this.destroy();
		}
		
		if(notDestroyed){
			ArrayList<GeneralEntity> collidingWith = EntityHelper.getCollidingEntities(this);
			for(GeneralEntity e : collidingWith){
				if(e instanceof GeneralEnemyEntity){
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
