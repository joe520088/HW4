package hw4.simulation;

import java.util.Random;
import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Grid;

public class Simulation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int size = 3 + random.nextInt(5);
		Game game = new Game(size);
		Grid grid = game.getGrid();
		
		boolean running = true;
		boolean exited = false;

	}

}
