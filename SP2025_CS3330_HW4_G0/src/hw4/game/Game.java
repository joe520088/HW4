package hw4.game;

import java.util.ArrayList;
import java.util.Random;

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

}
