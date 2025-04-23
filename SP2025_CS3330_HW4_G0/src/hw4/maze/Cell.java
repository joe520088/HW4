package hw4.maze;

public class Cell {

	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	


/**parameterized constructor for Cell, basically given in the CellTest
 * @param left
 * @param right
 * @param up
 * @param down
 */
public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
	
	this.setUp(up);
	this.setDown(down);
	this.setLeft(left);
	this.setRight(right);

}



public CellComponents getUp() {
	return up;
}



public void setUp(CellComponents up) {
	if(up == null) {
		this.up = CellComponents.WALL;
	}		
	else {
		this.up = up;
	}
}


public CellComponents getDown() {
	return down;
}



public void setDown(CellComponents down) {
	if(down == null) {
		this.down = CellComponents.WALL;
	}		
	else {
		this.down = down;
	}
}


public CellComponents getLeft() {
	return left;
}



public void setLeft(CellComponents left) {
	if(left == null) {
		this.left = CellComponents.WALL;
	}		
	else {
		this.left = left;
	}
}



public CellComponents getRight() {
	return right;
}



public void setRight(CellComponents right) {
	if(right == null) {
		this.right = CellComponents.WALL;
	}		
	else {
		this.right = right;
	}
}


@Override
public String toString() {
	return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
}








}