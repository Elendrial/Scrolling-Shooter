package me.hii488.scrollingShooter;

import me.hii488.gameWorld.World;
import me.hii488.gameWorld.Initialisation.IInitilisation;
import me.hii488.gameWorld.Initialisation.WorldInitialisation;
import me.hii488.gameWorld.tickControl.TickController;
import me.hii488.objects.entities.Player;
import me.hii488.scrollingShooter.additionalTickers.GameController;
import me.hii488.scrollingShooter.additionalTickers.LevelLogic;
import me.hii488.scrollingShooter.containers.LevelContainer;
import me.hii488.scrollingShooter.containers.MainMenuContainer;
import me.hii488.scrollingShooter.entities.ScrollingShooterPlayer;
import me.hii488.scrollingShooter.entities.enemies.BossEnemy;
import me.hii488.scrollingShooter.entities.enemies.EasyShooterEnemy;
import me.hii488.scrollingShooter.entities.enemies.HardShooterEnemy;
import me.hii488.scrollingShooter.entities.enemies.StandardEnemy;
import me.hii488.scrollingShooter.tiles.BackgroundTile;
import me.hii488.scrollingShooter.tiles.InvisibleWallTile;

public class Initilisation implements IInitilisation{

	public static Initilisation initClass = new Initilisation();
	
	public static GameController gameController = new GameController();
	public static LevelLogic enemyLogic = new LevelLogic();
		
	public static void gameSetup(){
		WorldInitialisation.initList.add(initClass);
		TickController.additionalEarlyTicking.add(gameController);
		TickController.additionalEarlyTicking.add(enemyLogic);
		
	}
	
	@Override
	public void preInit() {
		tilePreInit();
		containerPreInit();
		entityPreInit();
		worldPreInit();
	}
	
	@Override
	public void init() {
		worldInit();
		entityInit();
	}
	
	
	public static BackgroundTile backgroundTile;
	public static InvisibleWallTile invisWallTile;
	
	public void tilePreInit(){
		backgroundTile = new BackgroundTile();
		backgroundTile.setup();
		
		invisWallTile = new InvisibleWallTile();
		invisWallTile.setup();
	}
	
	
	public static LevelContainer levelContainer = new LevelContainer();
	public static MainMenuContainer menuContainer = new MainMenuContainer();
	
	public void containerPreInit(){
		levelContainer.setup();
		levelContainer.grid.fillRectWithTile(backgroundTile, 0, 0, levelContainer.grid.gridSize[0], levelContainer.grid.gridSize[1]);
		levelContainer.grid.wallRectWithTile(invisWallTile, 0, 0, levelContainer.grid.gridSize[0], levelContainer.grid.gridSize[1]);
		if(!World.Containers.containerExists(levelContainer.ID))World.Containers.addContainer(levelContainer);
		
		menuContainer.setup();
		menuContainer.grid.fillRectWithTile(backgroundTile, 0, 0, menuContainer.grid.gridSize[0], menuContainer.grid.gridSize[1]);
		if(!World.Containers.containerExists(menuContainer.ID))World.Containers.addContainer(menuContainer);
	}
	
	
	public static StandardEnemy standardEnemy = new StandardEnemy();
	public static EasyShooterEnemy easyShooterEnemy = new EasyShooterEnemy();
	public static HardShooterEnemy hardShooterEnemy = new HardShooterEnemy();
	public static BossEnemy bossEnemy = new BossEnemy();
	
	public void entityPreInit(){
		standardEnemy.setup();
		easyShooterEnemy.setup();
		hardShooterEnemy.setup();
		bossEnemy.setup();
	}
	
	public void entityInit(){}
	
	
	public static Player p = new ScrollingShooterPlayer();
	public void worldPreInit(){
		World.player = p;
	}
	
	public void worldInit(){
		World.Containers.loadNewContainer(menuContainer.ID);
	}

}
