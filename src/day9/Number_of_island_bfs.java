package day9;
import java.util.*;
 class Pr
{
	static int first=0;
    static int second=0;
	public Pr(int i,int j)
	{
	first=i;
	second=j;
	}
}
public class Number_of_island_bfs {
	static int numIsland(char grid[][])
	{
		int max=0;
		int m=grid.length;
		int n=grid[0].length;
		int visit[][]=new int[m][n];
		int nrow[]= {0,1,0,-1,1,-1,1,-1};
		int ncol[]= {1,0,-1,0,1,-1,-1,1};
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(grid[i][j]=='1' && visit[i][j]==0)
				{
				max++;
				bfs(grid,i,j,nrow,ncol,visit);
				}
			}
		}
		return max;
	}
	
	static void bfs(char[][] grid,int row,int col,int[] nrow,int[] ncol,int[][] visit)
	{
		Queue<Pr> q=new LinkedList<>();
		q.add(new Pr(row,col));
		visit[row][col]=1;
		while(!q.isEmpty())
		{
			Pr pair=q.poll();
			int n=pair.first;
			int m=pair.second;
			for(int i=0;i<8;i++)
			{
				int nn=n+nrow[i];
				int mm=m+ncol[i];
				if( nn>=0 && nn<grid.length && mm>=0 && mm<grid[0].length && grid[nn][mm]=='1' && visit[nn][mm]==0)
				{
					q.add(new Pr(nn,mm));
					visit[nn][mm]=1;
				}
			}
		}
	}
   
	public static void main(String args[])
    {
    	char grid[][]= { {'1','0','0','1','0'},
				         {'1','1','0','1','0'},
				         {'1','1','0','0','0'},
				         {'0','0','0','0','1'
					}};
		
		System.out.println("the number of island is "+numIsland(grid));
    }
}
