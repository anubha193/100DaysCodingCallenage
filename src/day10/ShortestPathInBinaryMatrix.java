package day10;

import java.util.LinkedList;
import java.util.Queue;
public class ShortestPathInBinaryMatrix {
	public static int shortestPathBinaryMatrix(int[][] grid) {
	    
	    return BFS(grid, 0, 0, grid.length-1, grid[0].length-1);
	    
	}


	public static int BFS(int grid[][], int start_x, int start_y , int target_x, int target_y){
	    
	    Queue<Pair> q = new LinkedList<>();
	  
	    q.add(new Pair(start_x, start_y, 1));
	    
	    while(q.size()>0){
	        
	        Pair rem = q.remove();
	        int x = rem.first;
	        int y = rem.second;
	        int count = rem.step;
	       
	if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]!=1 ){
	        
	        grid[x][y] = 1;
	            
	        if(x==target_x && y== target_y)
	            return rem.step;
	        
	        q.add(new Pair(x-1, y, count+1 ));
	        q.add(new Pair(x-1, y+1, count+1));
	        q.add(new Pair(x, y+1 , count+1));
	        q.add(new Pair(x+1, y+1, count+1));
	        q.add(new Pair(x+1, y, count+1));
	        q.add(new Pair(x+1, y-1, count+1));
	        q.add(new Pair(x, y-1, count+1));
	        q.add(new Pair(x-1, y-1, count+1));
	            
	      }

	   }
	    return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid= {{0,1},{1,0}};
		System.out.println("the shortest path in binary matrix is= "+ shortestPathBinaryMatrix(grid));
	}}
