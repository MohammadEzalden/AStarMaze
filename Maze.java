package com.company.azoz;

public class Maze {
	 /*
      	0 = Not Visited Cell
        1 = Wall
        2 = Visited Cell
        9 = Target Cell
     */
  public static int[][] arr = new int[][]
	{ {1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,0,1,0,1,0,1,0,0,0,0,0,1},
      {1,0,1,0,0,0,1,0,1,1,1,0,1},
      {1,0,0,0,1,1,1,0,0,0,0,0,1},
      {1,0,1,0,0,0,0,0,1,1,1,0,1},
      {1,0,1,0,1,1,1,0,1,0,0,0,1},
      {1,0,1,0,1,0,0,0,1,1,1,0,1},
      {1,0,1,0,1,1,1,0,1,0,1,0,1},
      {1,0,0,0,0,0,0,0,0,0,1,9,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public static void main(String[] args) {
    	
    	Cell cell;
        cell=AStar.getPathAStar(arr,1,1,0);
        System.out.println(cell);
    	while (cell.parent!=null){
            System.out.println(cell.parent);
            cell=cell.parent;
        }

    }
}
