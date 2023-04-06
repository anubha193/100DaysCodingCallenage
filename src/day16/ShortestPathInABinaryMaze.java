package day16;
import java.util.*;
//8-directional binary maze
public class ShortestPathInABinaryMaze {
	 public static int shortestPathBinaryMatrix(int[][] grid) {
	        int n=grid.length;
	         int m=grid[0].length;
	        if(grid[0][0]==0 && n==1 && m==1)return 1;
	        if(grid[0][0]==1)return -1;
	        int nrow[]={1,0,-1,0,1,1,-1,-1};
	        int ncol[]={0,1,0,-1,-1,1,1,-1};
	        Queue<Tuple> q=new LinkedList<>();
	      int[][] dist = new int[n][m]; 
	        for(int i = 0;i<n;i++) {
	            for(int j =0;j<m;j++) {
	                dist[i][j] = (int)(1e9); 
	            }
	        }
	        q.add(new Tuple(1,0,0));
	        dist[0][0]=0;
	        while(!q.isEmpty())
	        {
	            int first=q.peek().first;
	            int second=q.peek().second;
	            int third=q.peek().third;
	            q.poll();
	            for(int i=0;i<8;i++)
	            {
	               int er=second+nrow[i];
	               int ec=third+ncol[i];
	               if(er>=0 && er<n && ec>=0 && ec<m && grid[er][ec]==0)
	               {
	                   if(dist[er][ec]>first+1)
	                   {
	                   dist[er][ec]=first+1;
	                   if(er == n-1 && 
	                       ec == m-1) return first + 1;
	                   q.add(new Tuple(first+1,er,ec));
	                   }
	               }
	            }
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] grid= {{0,1},{1,0}};
       System.out.println("the Shortest path in a binary maze is="+shortestPathBinaryMatrix(grid));
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
