package day16;
import java.util.*;
public class PathWithMinimumEffort {
	static int MinimumEffort(int grid[][]) {
        int n=grid.length;
        int m=grid[0].length;
         int[][] dist = new int[n][m]; 
	        for(int i = 0;i<n;i++) {
	            for(int j =0;j<m;j++) {
	                dist[i][j] = (int)(1e9); 
	            }
	        }
	        PriorityQueue<Tuple> q = 
        new PriorityQueue<Tuple>((x,y) -> x.first - y.first);
	         dist[0][0] = 0; 
             q.add(new Tuple(0, 0, 0)); 
             int[] nrow={1,0,-1,0};
             int[] ncol={0,1,0,-1};
             while(!q.isEmpty())
             {
                int first=q.peek().first;
	            int second=q.peek().second;
	            int third=q.peek().third;
	            q.poll();
	             if(second== n-1 && third == m-1) return first; 
	             for(int i=0;i<4;i++)
	            {
	               int er=second+nrow[i];
	               int ec=third+ncol[i];
	               if(er>=0 && er<n && ec>=0 && ec<m)
	               {
	                  int newEffort = 
                    Math.max(
                        Math.abs(grid[second][third] - grid[er][ec]), first); 
                    if(newEffort < dist[er][ec]) {
                        dist[er][ec] = newEffort; 
                        q.add(new Tuple(newEffort, er, ec)); 
                    } 
	               }
	            }
	            
             }
      return -1;
      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid= {{1,2,2},{3,8,2},{5,3,5}};
		System.out.println("The route of [1,3,5,3,5] has a maximum absolute difference of "+MinimumEffort(grid)+ " in consecutive cells.");

	}
}
class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third=third;
    }
}
