package day10;
import java.util.LinkedList;
import java.util.Queue;
class Pair
{
	int first=0;
	int second=0;
	int step=0;
	Pair(int first,int second,int step)
	{
		this.first=first;
		this.second=second;
		this.step=step;
	}
}
public class AsFarAsLandIsPossible {
	 static int[][] countDistance(int[][] grid)
	    {
	    	  int n = grid.length; 
	  	    int m = grid[0].length; 
	  	    // visited and distance matrix
	  	    int vis[][] = new int[n][m]; 
	  	    int dist[][] = new int[n][m]; 
	  	    // <coordinates, steps>
	  	    Queue<Pair> q = new LinkedList<Pair>();
	  	    // traverse the matrix
	  	    for(int i = 0;i<n;i++) {
	  	        for(int j = 0;j<m;j++) {
	  	        // start BFS if cell contains 1
	  	            if(grid[i][j] == 1) {
	  	                q.add(new Pair(i, j, 0)); 
	  	                vis[i][j] = 1; 
	  	            }
	  	            else {
	  	                vis[i][j] = 0; 
	  	            }
	  	        }
	  	    }
	  	    int delrow[] = {-1, 0, +1, 0}; 
	  	    int delcol[] = {0, +1, 0, -1}; 
	  	    while(!q.isEmpty()) {
	  	        int row = q.peek().first; 
	  	        int col = q.peek().second; 
	  	        int steps = q.peek().step; 
	  	        q.remove(); 
	  	        dist[row][col] = steps; 
	  	        for(int i = 0;i<4;i++) {
	  	            int nrow = row + delrow[i]; 
	  	            int ncol = col + delcol[i]; 
	  	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
	  	            && vis[nrow][ncol] == 0)  {
	  	                    vis[nrow][ncol] = 1; 
	      	            q.add(new Pair(nrow, ncol, steps+1));  
	  	            } 
	  	            }
	  	        }
	  	    
	  	    return dist; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]=  {{1,0,1},{0,0,0},{1,0,1}};
        int dis[][]=countDistance(grid);
        System.out.println("the distance matrix is=");
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dis.length;i++)
        {
        	for(int j=0;j<dis[0].length;j++)
        	{
        		max=Math.max(max, dis[i][j]);
        		System.out.print(dis[i][j]+" ");
        	}
        	System.out.println();
        }
        System.out.println(max);

	}

}
