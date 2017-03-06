/**
 * Harkirat Kang
 * CS 284B
 * Assignment 3
 * I pledge my honor that I have abided by the Stevens honor system
 */

package Maze;

import java.util.ArrayList;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {
	

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
    	if (x<0 || x> maze.getNCols() -1|| y <0 || y > maze.getNRows() -1){
    		return false;
    	} else if (!maze.getColor(x, y).equals(NON_BACKGROUND)){
    		return false;
    	} else if (!maze.getColor(x, y).equals(TEMPORARY)){
    		return false;	
    	} else if (x == maze.getNCols()-1 || y == maze.getNRows()-1){
    		maze.recolor(x,y, PATH);
    		return true;
    	} else {
    		maze.recolor(x,y, PATH);
    		if (findMazePath(x, y-1) || findMazePath(x-1, y) || findMazePath(x+1, y) || findMazePath(x, y+1)){
    			maze.recolor(x, y, TEMPORARY);
    		}
    		return true;
    	}
    }
    
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(){
    	return findAllMazePaths(0,0);
    }
 
    
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y){
    	return findMazePath(x, y, new ArrayList<PairInt>());
    }
 
    
    public ArrayList <ArrayList <PairInt>> findMazePath(int x, int y, ArrayList <PairInt > current) {
    	if (x<0 || x> maze.getNCols() -1|| y <0 || y > maze.getNRows() -1){
    		return new ArrayList<>();
    	} else if (!maze.getColor(x, y).equals(NON_BACKGROUND)){
    		return new ArrayList<>();
    	} else if (!maze.getColor(x, y).equals(TEMPORARY)){
    		return new ArrayList<>();
    	} else if (x == maze.getNCols()-1 || y == maze.getNRows()-1){
    		current.add(new PairInt(x,y));
    		ArrayList<ArrayList<PairInt>> CopyPair = new ArrayList();
    		return CopyPair;
    	} else{
    		maze.recolor(x,y, PATH);
    		current.add(new PairInt(x, y));
			ArrayList<ArrayList<PairInt>> CopyPair = new ArrayList<ArrayList<PairInt>>();
			CopyPair.addAll(findMazePath(x + 1, y, current));
			CopyPair.addAll(findMazePath(x - 1, y, current));
			CopyPair.addAll(findMazePath(x, y + 1, current));
			CopyPair.addAll(findMazePath(x, y - 1, current));
		
    		return CopyPair;
    	}

    	
    }
    
    public ArrayList<PairInt> findMazePathMin(int x, int y){
    	ArrayList<ArrayList<PairInt>> bestPath = findMazePath(0, 0, new ArrayList<PairInt>());
    	if (bestPath.isEmpty())
    		return new ArrayList<PairInt>();
    	int minIndex = 0;
    	for (int i = 0; i < bestPath.size(); i++){
    		if (bestPath.get(i).size() <= bestPath.get(minIndex).size())
    			minIndex = i;
    	}
    	return bestPath.get(minIndex);
    }
    

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
