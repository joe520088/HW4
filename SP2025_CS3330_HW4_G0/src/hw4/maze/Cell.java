package hw4.maze;

public class Cell {
	
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	public Cell(CellComponents left, CellComponents right,CellComponents up,CellComponents down)
	{
		setLeft(left);
		setRight(right);
		setUp(up);
		setDown(down);
		
	}

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		this.left = left;
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		this.right = right;
	}

	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		this.up = up;
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		this.down = down;
	}
	
	

	
}
