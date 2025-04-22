package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	private Row currentRow;
	private Cell currentCell;
	
	public Player(Row currentRow, Cell currentCell) {
		
	}

	public Row getCurrentRow() {
		return currentRow;
	}



	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}



	public Cell getCurrentCell() {
		return currentCell;
	}



	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	
}
