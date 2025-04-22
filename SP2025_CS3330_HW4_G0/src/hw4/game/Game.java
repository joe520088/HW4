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
	
	/**
	 * Constructs a game with a predefined grid
	 * 
	 * @param grid
	 * 		The grid to use for the game
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}

	/**
	 * Constructs a game with a randomly generated grid of a specified size
	 * 
	 * @param size
	 * 		The size of the grid
	 */
	public Game(int size) {
		this.grid = createRandomGrid(size);
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	/**
	 * Processes a players movement attempt in a specified direction and updates the
	 * players position if the movement is valid
	 * 
	 * @param movement
	 * 		The direction in which the player is trying to move
	 * @param player
	 * 		The player making the movement
	 * @return true if the movement was successful, false otherwise
	 */
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
	
	/**
	 * Creates a randomly created grid with a specified size. 
	 * The grid contains an exit on a random row on the left column.
	 * 
	 * @param size
	 * 		The size of the grid to create
	 * @return
	 * 		A new Grid object with a random layout or null if size is invalid
	 */
	public Grid createRandomGrid(int size) {
		if(size < 3 || size > 7) {
			return null;
		}
		
		ArrayList<Row> rows = new ArrayList<>();
		int exitRow = random.nextInt(size);
		
		for(int i = 0; i < size; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
			
			for(int j = 0; j < size; j++) {
				CellComponents left;
				CellComponents up;
				CellComponents right;
				CellComponents down;

				if (j == 0) {
					if (i == exitRow) {
						left = CellComponents.EXIT;
					} 
					else {
						left = CellComponents.WALL;
					}
				} 
				else {
					left = cells.get(j - 1).getRight();
				}

				if (i == 0) {
					up = CellComponents.WALL;
				} 
				else {
					up = rows.get(i - 1).getCells().get(j).getDown();
				}

				if (j < size - 1) {
					right = getRandomComponent(); 
				} 
				else {
					right = CellComponents.WALL;
				}

				if (i < size - 1) {
					down = getRandomComponent();
				} 
				else {
					down = CellComponents.WALL;
				}
					
				Cell cell = new Cell(left, right, up, down);
				cells.add(cell);
			}
			
			Row row = new Row(cells);
			rows.add(row);
		}
		
		return new Grid(rows);
	}

	/**
	 * Generates a random cell component, either a wall or aperture
	 * 
	 * @return
	 * 		A randomly chosen CellComponents value
	 */
	private CellComponents getRandomComponent() {
		if(random.nextBoolean()) {
			return CellComponents.WALL;
		}
		else {
			return CellComponents.APERTURE;
		}
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
	
}