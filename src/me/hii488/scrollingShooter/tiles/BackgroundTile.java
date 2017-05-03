package me.hii488.scrollingShooter.tiles;

import me.hii488.objects.tileTypes.BaseTile;

public class BackgroundTile extends BaseTile {

	@Override
	public void setup() {
		this.textureName = "blackbackground.png";
		this.zLayer = 0;
		this.isCollidable = false;
		super.setup();
	}

}
