package me.hii488.scrollingShooter.entities.enemies;

import me.hii488.gameWorld.World;
import me.hii488.objects.entities.GeneralEntity;
import me.hii488.scrollingShooter.entities.Bullet;

public class GeneralEnemyEntity extends GeneralEntity{
	
	public int health = 1;
	public boolean canShoot = false;

	public float speed = 2;
	public int movementType = 0;
	
	public GeneralEnemyEntity(){}
	
	public GeneralEnemyEntity(GeneralEnemyEntity e) {
		super(e);
		this.health = e.health;
		this.speed = e.speed;
		this.movementType = e.movementType;
	}
	
	@Override
	public void updateOnTick(){
		switch(movementType){ // 0 : right down, 1 : left down, 2: right, 3: left, 4: right up, 5: left up
		case 0:
			this.position.addToLocation(speed, speed/2f);
			break;
		case 1:
			this.position.addToLocation(-speed, speed/2f);
			break;
		case 2:
			this.position.addToLocation(speed, 0);
			break;
		case 3:
			this.position.addToLocation(-speed, 0);
			break;
		case 4:
			this.position.addToLocation(speed, -speed/2f);
			break;
		case 5:
			this.position.addToLocation(-speed, -speed/2f);
			break;
		case 6:
			this.position.addToLocation(World.rand.nextFloat() < 0.4 ? -speed: speed, speed/2);
			break;
		case 7:
			this.position.addToLocation(World.rand.nextFloat() < 0.4 ? speed: -speed, speed/2);
			break;
		}
		
		super.updateOnTick();
	}
	
	public void updateOnRandTick(){}
	
	public GeneralEnemyEntity clone(){
		return new GeneralEnemyEntity(this);
	}
	
	public void isShot(Bullet b){}
	
}
