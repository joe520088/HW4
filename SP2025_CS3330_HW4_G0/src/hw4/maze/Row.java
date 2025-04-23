package hw4.maze;

import java.util.ArrayList;

public class Row {

	//A row is made up from a list of cells
	private ArrayList<Cell> cells;
	
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}


	/**Parameterized constructor for a row that takes cells as input
	 * @param cells
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	

	//getter for the cell list in row
	public ArrayList<Cell> getCells() {
		return cells;
	}
	//setter for the lists of cells in the row
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	

}
