package com.company.azoz;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class AStar {
	
	public static Comparator<Cell> coastComparator = new Comparator<Cell>(){
		
		@Override
		public int compare(Cell c1, Cell c2) {
			int manHD1=manhattanDistance(c1,new Cell(8,11,null));// ad c 9 12
			int manHD2=manhattanDistance(c2,new Cell(8,11,null));// ad c 9 12
			if(c1.cost+manHD1>c2.cost+manHD2)return 1;
			if(c1.cost+manHD1<c2.cost+manHD2)return -1;
            return  0;// Write your code here!
        }
	};
	
	public static int manhattanDistance(Cell c1 , Cell c2) {
		
		return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
	}
	
	
	public static Queue<Cell> pq =  new PriorityQueue<>(coastComparator);
	
	public static Cell getPathAStar(int[][] arr , int x, int y , int cost) {

		pq.add(new Cell(1,1,0,null));
		arr[1][1]=2;
		Cell c=null;
		while (!pq.isEmpty()){
			c=pq.poll();
			arr[c.x][c.y]=2;
			if(arr[c.x][c.y]==9||(c.x==8&&c.y==11))return c;
			if(isFree(c.x+1,c.y,arr)){
				pq.add(new Cell(c.x+1,c.y,c.cost+1,c));
			}
			if(isFree(c.x-1,c.y,arr)){
				pq.add(new Cell(c.x-1,c.y,c.cost+1,c));
			}
			if(isFree(c.x,c.y+1,arr)){
				pq.add(new Cell(c.x,c.y+1,c.cost+1,c));
			}
			if(isFree(c.x,c.y-1,arr)){
				pq.add(new Cell(c.x,c.y-1,c.cost+1,c));

			}

		}
		// To pop from the queue use 'pq.remove();'
		// To push into the queue use 'pq.add(cell);'
		
		// Write your code here!
		
		return c;
	}
	
	public static boolean isFree(int x, int y , int[][] arr) {
		
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 0 || arr[x][y] == 9)) {
            return true;
        }
        return false;
    }
	
}
