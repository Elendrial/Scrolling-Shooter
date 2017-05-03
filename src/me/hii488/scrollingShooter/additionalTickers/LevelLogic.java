package me.hii488.scrollingShooter.additionalTickers;

import me.hii488.gameWorld.World;
import me.hii488.gameWorld.tickControl.ITickable;
import me.hii488.general.Position;
import me.hii488.scrollingShooter.Initilisation;
import me.hii488.scrollingShooter.entities.enemies.GeneralEnemyEntity;

public class LevelLogic implements ITickable{

	
	@Override
	public boolean alwaysTicks() {return true;}

	@Override
	public float randTickChance() {return 0.001f;}
	
	@Override
	public void updateOnTick() {
		spawnInWave();
		
		// If there's been a non-boss wave, wait a bit.
		if(waveType >= 0 && waveProgress < 0){
			waveType = -1;
			waveProgress = 200 - 10 * (Initilisation.gameController.level - 1);
		}
		
		// If you've just waited...
		if(waveType == -1 && waveProgress < 0){
			// and you've done n+ waves, do a boss level
			if(wavesThisLevel >= 7){
				wavesThisLevel = 0;
				waveType = -2;
				waveProgress = -4;
				Initilisation.gameController.level++;
				Initilisation.initClass.entityPreInit();
			}
			// else, just choose a random wave type.
			else{
				waveType = World.rand.nextInt(totalWaveTypes);
				waveProgress = -40; /*Use -40 so things can choose how long the wave needs to be*/
			}
		}
		// If you complete a boss wave, wait a bit.
		if(waveType == -2 && waveProgress == -2){
			waveType = -1;
			waveProgress = 150;
		}
	}
	
	@Override
	public void updateOnSec() {}

	@Override
	public void updateOnRandTick() {}
	
	
	public int waveType = 0;
	public int waveProgress = 140; // Wave progress is how far through spawning the wave this is, not the player's progress in destroying the wave.
	public int wavesThisLevel = 0;
	private GeneralEnemyEntity se, se2;
	public int totalWaveTypes = 14;
	
	public int general = 0;
	
	public void spawnInWave(){
		if(World.currentWorldContainerID == Initilisation.levelContainer.ID){
			
			
			//					-------------------------	0	---------------------- STANDARD, NO SHOOT, DIAGONAL
			if(waveType == 0){
				if(World.rand.nextFloat() < 0.2 * Initilisation.gameController.level){
					waveType = World.rand.nextInt(totalWaveTypes);
					return;
				}
				
				final int waitScale = 14;
				boolean spawn = false;
				
				se = Initilisation.standardEnemy.clone();
				se2 = Initilisation.standardEnemy.clone();
				se.movementType = 0;
				se2.movementType = 1;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			//			-------------------------	1	---------------------- STANDARD, NO SHOOT, FLAT
			
			
			if(waveType == 1){
				if(World.rand.nextFloat() < 0.2 * Initilisation.gameController.level){
					waveType = World.rand.nextInt(totalWaveTypes);
					return;
				}
				
				final int waitScale = 14;
				boolean spawn = false;
				
				se = Initilisation.standardEnemy.clone();
				se2 = Initilisation.standardEnemy.clone();
				se.movementType = 2;
				se2.movementType = 3;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			//			-------------------------	2	---------------------- STANDARD, EASY SHOOT, FLAT
			
			if(waveType == 2){
				if(World.rand.nextFloat() < 0.1 * Initilisation.gameController.level){
					waveType = World.rand.nextInt(totalWaveTypes);
					return;
				}
				
				final int waitScale = 16;
				boolean spawn = false;
				
				se = Initilisation.easyShooterEnemy.clone();
				se2 = Initilisation.easyShooterEnemy.clone();
				se.movementType = 2;
				se2.movementType = 3;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			//			-------------------------	3	---------------------- STANDARD, EASY SHOOT, DIAGONAL
			
			if(waveType == 3){
				if(World.rand.nextFloat() < 0.1 * Initilisation.gameController.level){
					waveType = World.rand.nextInt(totalWaveTypes);
					return;
				}
				
				final int waitScale = 16;
				boolean spawn = false;
				
				se = Initilisation.easyShooterEnemy.clone();
				se2 = Initilisation.easyShooterEnemy.clone();
				se.movementType = 0;
				se2.movementType = 1;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			//			-------------------------	4	---------------------- STANDARD, HARD SHOOT, DIAGONAL
			
			if(waveType == 4){
				final int waitScale = 18;
				boolean spawn = false;
				
				se = Initilisation.hardShooterEnemy.clone();
				se2 = Initilisation.hardShooterEnemy.clone();
				se.movementType = 0;
				se2.movementType = 1;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			//			-------------------------	5	---------------------- STANDARD, HARD SHOOT, FLAT
			
			if(waveType == 5){
				final int waitScale = 18;
				boolean spawn = false;
				
				se = Initilisation.hardShooterEnemy.clone();
				se2 = Initilisation.hardShooterEnemy.clone();
				se.movementType = 2;
				se2.movementType = 3;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			
			//			-------------------------	6	---------------------- STANDARD, RAND SHOOT, FLAT
			
			if(waveType == 6){
				final int waitScale = 17;
				boolean spawn = false;
				
				se = chooseRandomEnemy();
				se2 = chooseRandomEnemy();
				se.movementType = 2;
				se2.movementType = 3;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 14);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 10);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			//			-------------------------	7	---------------------- STANDARD, RAND SHOOT, DIAGONAL
			
			if(waveType == 7){
				final int waitScale = 17;
				boolean spawn = false;
				
				se = chooseRandomEnemy();
				se2 = chooseRandomEnemy();
				se.movementType = 0;
				se2.movementType = 1;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 12 * waitScale + 2;
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, 8);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, 8);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			//			-------------------------	8	---------------------- RAND, EASY SHOOT, DIAGONAL
			
			if(waveType == 8){
				final int waitScale = 18;
				boolean spawn = false;

				se = Initilisation.easyShooterEnemy.clone();
				se2 = Initilisation.easyShooterEnemy.clone();
				se.movementType = (int) randTwoObject(0,4);
				se2.movementType = (int) randTwoObject(1,5);
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 10 * waitScale + 2;
				
				switch(waveProgress){
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			//			-------------------------	9	---------------------- RAND, EASY SHOOT, FLAT
			
			if(waveType == 9){
				final int waitScale = 18;
				boolean spawn = false;

				se = Initilisation.easyShooterEnemy.clone();
				se2 = Initilisation.easyShooterEnemy.clone();
				se.movementType = 0;
				se2.movementType = 1;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 10 * waitScale + 2;
				
				switch(waveProgress){
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			//			-------------------------	10	---------------------- RAND, HARD SHOOT, FLAT
			
			if(waveType == 10){
				final int waitScale = 20;
				boolean spawn = false;

				se = Initilisation.hardShooterEnemy.clone();
				se2 = Initilisation.hardShooterEnemy.clone();
				se.movementType = 0;
				se2.movementType = 1;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 9 * waitScale + 2;
				
				switch(waveProgress){
				
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			//			-------------------------	11	---------------------- RAND, HARD SHOOT, DIAGONAL
			
			if(waveType == 11){
				final int waitScale = 20;
				boolean spawn = false;

				se = Initilisation.hardShooterEnemy.clone();
				se2 = Initilisation.hardShooterEnemy.clone();
				se.movementType = (int) randTwoObject(0,4);
				se2.movementType = (int) randTwoObject(1,5);
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40) waveProgress = 9 * waitScale + 2;
				
				switch(waveProgress){
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-1));
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			
			//			-------------------------	12	---------------------- WAVE, EASY SHOOT, DIAGONAL																																
			
			if(waveType == 12){
				final int waitScale = 17;
				boolean spawn = false;

				se = Initilisation.easyShooterEnemy.clone();
				se2 = Initilisation.easyShooterEnemy.clone();
				se.movementType = (int) randTwoObject(0,4);
				se2.movementType = (int) randTwoObject(1,5);
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40){
					waveProgress = 12 * waitScale + 2;
					general = World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-5);
				}
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			//			-------------------------	13	---------------------- WAVE, EASY SHOOT, FLAT
			
			if(waveType == 13){
				final int waitScale = 15;
				boolean spawn = false;

				se = Initilisation.easyShooterEnemy.clone();
				se2 = Initilisation.easyShooterEnemy.clone();
				se.movementType = 0;
				se2.movementType = 1;
				
				se.speed = 3 + (1 * (Initilisation.gameController.level-1)) + 0.1f*this.wavesThisLevel;
				se2.speed = 3 + (1 * (Initilisation.gameController.level-1))+ 0.1f*this.wavesThisLevel;
				
				if(waveProgress == -40){
					waveProgress = 12 * waitScale + 2;
					general = World.rand.nextInt(World.getCurrentWorldContainer().grid.gridSize[1]-5);
				}
				
				switch(waveProgress){
				case 12 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 11 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 10 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 9 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 8 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 7 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 6 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 5 * waitScale :
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 4 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 3 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 2 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 1 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					break;
				case 0 * waitScale : 
					se.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(1, general + waveProgress/waitScale);
					se2.position = World.getCurrentWorldContainer().grid.getPositionFromTileCoords(World.getCurrentWorldContainer().grid.gridSize[0]-1, general + waveProgress/waitScale);
					spawn = true;
					this.wavesThisLevel +=1;
					break;
				}
				
				if(spawn){
					World.getCurrentWorldContainer().addEntity(se.clone());
					World.getCurrentWorldContainer().addEntity(se2.clone());
				}
			}
			
			
			//	BOSS \\ //	BOSS \\ //	BOSS \\ //	BOSS \\ //	BOSS \\ //	BOSS \\ //	BOSS \\ //	BOSS \\ 
			if(waveType == -2 && waveProgress == -4){
				waveProgress++;
				Initilisation.bossEnemy.bossState = -1;
				Initilisation.bossEnemy.position = new Position(World.mainWindow.width/2 - Initilisation.bossEnemy.currentTexture.getWidth()/2, 0.5f);
				World.getCurrentWorldContainer().addEntity(Initilisation.bossEnemy.clone());
			}
			
			if(waveProgress >= 0) waveProgress--;
		}
	}
	
	public static GeneralEnemyEntity chooseRandomEnemy(){
		switch(World.rand.nextInt(3)){
		case 0:
			return Initilisation.standardEnemy.clone();
		case 1:
			return Initilisation.easyShooterEnemy.clone();
		case 2:
			if(World.rand.nextBoolean()) return Initilisation.hardShooterEnemy.clone();
			else return chooseRandomEnemy();
		}
		return Initilisation.standardEnemy.clone();
	}
	
	public static Object randTwoObject(Object a, Object b){
		return World.rand.nextBoolean() ? a : b;
	}
	
}
