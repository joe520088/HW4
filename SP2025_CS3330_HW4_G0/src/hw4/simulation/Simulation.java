package hw4.simulation;

import java.util.Random;
import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Simulation {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate random grid size 
        int size = 3 + random.nextInt(5);
        Game game = new Game(size);
        Grid grid = game.getGrid();
        
        // always set player position at the bottom right of the grid
        Row startRow = grid.getRows().get(size - 1);
        Cell startCell = startRow.getCells().get(size - 1);
        Player player = new Player(startRow, startCell);
        
        // declare value for running and exited
        boolean running = true;
        boolean exited = false;

        // function to tell player how to move 
        while (running) 
		{
            printGrid(grid, player);
            if (isAtExit(player)) 
			{
                System.out.println("You're at the EXIT cell. Move LEFT to escape!");
            }

            System.out.print("Enter move (W/A/S/D): ");
            String input = scanner.nextLine().toUpperCase();

            Movement move = null;
            switch (input) 
			{
                case "W":
                    move = Movement.UP;
                    break;
                case "A":
                    move = Movement.LEFT;
                    break;
                case "S":
                    move = Movement.DOWN;
                    break;
                case "D":
                    move = Movement.RIGHT;
                    break;
                default:
                    System.out.println("Invalid input. Use W/A/S/D.");
                    continue;
            }
            
            // to tell player when they hit a wall or can't moved
            boolean moved = game.play(move, player);
            if (!moved) 
			{
                System.out.println("Can't move in that direction!");
            }

            // Check if player escaped
            if (isAtExit(player) && move == Movement.LEFT) 
			{
                exited = true;
                break;
            }
        }
        
        // tells player if they won or lose
        printGrid(grid, player);
        if (exited) 
		{
            System.out.println("Congratulations! You escaped the maze!");
        } 
		else 
		{
            System.out.println("Game over.");
        }

        scanner.close();
    }

	/**
	 * 
	 * @param grid to show the game grid
	 * @param player current position 
	 */
    public static void printGrid(Grid grid, Player player) {
        for (Row row : grid.getRows()) 
		{
            for (Cell cell : row.getCells()) {
                if (player.getCurrentRow() == row && player.getCurrentCell() == cell) 
				{
                    System.out.print("A ");
                } 
				else if (cell.getLeft() == CellComponents.EXIT) 
				{
                    System.out.print("E ");
                } 
				else 
				{
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * check if player is on the exit cell
     * 
     * @param to check player 
     * @return it return true is the player cell is exit cell
     */
    private static boolean isAtExit(Player player) 
	{
        return player.getCurrentCell().getLeft() == CellComponents.EXIT;
    }

	
}
