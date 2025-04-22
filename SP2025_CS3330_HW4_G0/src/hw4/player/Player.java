package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	private Row currentRow;
	private Cell currentCell;
	
	/*
	 * 
	 * @param currentRow to get which row the player is located
	 * @param currentCell to get which cell the player is located
	 */
	
	
	public Player(Row currentRow, Cell currentCell) {
		super()
		this.currentRow = currentRow;
		this.currentCell = currentCelll;
	}
	
	// get current row of player
	public Row getCurrentRow() {
		return currentRow;
	}


	// set row where player is located
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}


	// get current cell of player location
	public Cell getCurrentCell() {
		return currentCell;
	}

	// set current cell of the player location
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	
	// return to string of the player location
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
}
