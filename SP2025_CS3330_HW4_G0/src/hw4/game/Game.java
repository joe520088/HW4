package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;
import hw4.maze.Grid;

public class Game {
	
	private Grid grid;
	private Random random = new Random();
	
	public Game(Grid grid) {
		this.grid = grid;
	}

	public Game(int size) {
		this.grid = createRandomGrid(size);
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	public boolean play(Movement movement, Player player) {
		if(movement == null || player == null) {
			return false;
		}
		
		Row currentRow = player.getCurrentRow();
		Cell currentCell = player.getCurrentCell();
		
		int rowIndex = grid.getRows().indexOf(currentRow);
		int cellIndex = currentRow.getCells().indexOf(currentCell);
		
		switch(movement) {
		case UP:
			if(currentCell.getUp() == CellComponents.APERTURE) {
				if(rowIndex > 0) {
					Row newRow = grid.getRows().get(rowIndex - 1);
					player.setCurrentRow(newRow);
					player.setCurrentCell(newRow.getCells().get(cellIndex));
					return true;
				}
			}
			break;
		case DOWN:
			if(currentCell.getDown() == CellComponents.APERTURE) {
				if(rowIndex < grid.getRows().size() - 1) {
					Row newRow = grid.getRows().get(rowIndex + 1);
					player.setCurrentRow(newRow);
					player.setCurrentCell(newRow.getCells().get(cellIndex));
					return true;
				}
			}
			break;
		case LEFT:
			if(currentCell.getLeft() == CellComponents.APERTURE) {
				if(cellIndex > 0) {
					player.setCurrentCell(currentRow.getCells().get(cellIndex - 1));
					return true;
				}
			}
			else if(currentCell.getLeft() == CellComponents.EXIT){
				return true;
			}
			break;
		case RIGHT:
			if(currentCell.getRight() == CellComponents.APERTURE) {
				if(cellIndex < currentRow.getCells().size() - 1) {
					player.setCurrentCell(currentRow.getCells().get(cellIndex + 1));
					return true;
				}
			}
			break;
		}
		
		return false;
	}

}
