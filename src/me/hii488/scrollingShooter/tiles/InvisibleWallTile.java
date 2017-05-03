package me.hii488.scrollingShooter.tiles;

import me.hii488.objects.tileTypes.BaseTile;

public class InvisibleWallTile extends BaseTile{
	
	@Override
	public void setup() {
		this.textureName = "invisWall.png";
		this.zLayer = 0;
		this.isCollidable = true;
		super.setup();
	}
	
}
