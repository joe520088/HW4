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



@Override
public String toString() {
	return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
}








}