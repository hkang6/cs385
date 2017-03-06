/*<listing chapter="5" number="3">*/
package recursion;

/**
 * Class that solves problem of counting abnormal cells.
 *  @author Koffman and Wolfgang
 **/
public class BlobStub implements GridColors {

    /** The grid */
    private TwoDimGrid grid;

    /** Constructors */
    public BlobStub(TwoDimGrid grid) {
        this.grid = grid;
    }

    /**
     * Finds the number of cells in the blob at (x,y).
     * @pre Abnormal cells are in ABNORMAL color;
     *      Other cells are in BACKGROUND color.
     * @post All cells in the blob are in the TEMPORARY color.
     * @param x The x-coordinate of a blob cell
     * @param y The y-coordinate of a blob cell
     * @return The number of cells in the blob that contains (x, y)
     */
    public int countCells(int x, int y) {
    	int result; 
    	
    	if (x<0 || x> grid.getNCols() || y <0 || y > grid.getNRows()){
    		return 0;
    	} if (!grid.getColor(x,y).equals(ABNORMAL)){
    	return 0;
    	} else {
    		grid.recolor(x, y, TEMPORARY);
    		return 1 + countCells(x - 1, y + 1) + countCells(x, y + 1) + countCells(x + 1, y + 1) + countCells(x - 1, y) + + countCells(x + 1, y) + countCells(x - 1, y - 1) + countCells(x, y - 1) + countCells(x + 1, y - 1);
    		
    	}
    	}
   


    /*<exercise chapter="5" section="5" type="programming" number="2">*/
    /** Restore the grid by returning all TEMPORARY cells to ABNORMAL */
    public void restore() {
        grid.recolor(TEMPORARY, ABNORMAL);
    }
    /*</exercise>*/
}