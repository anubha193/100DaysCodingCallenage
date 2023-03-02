package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	 public static  List<List<Integer>>   pacificAtlantic(int[][] board) {
	       int n=board.length;
		        int m=board[0].length;
		       int[][] visit=new int[n][m]; 
		        int[] row={1,0,-1,0};
		        int[] col={0,1,0,-1};
		        for(int j = 0 ; j<m;j++) {
	                 if(visit[0][j]==0)
		                dfs(visit,board,col,row,0,j); 
		            }
		        for(int i = 0;i<n;i++) {
	                if(visit[i][0]==0)
		                dfs(visit,board,col,row,i,0); 
		            }
	        int visit2[][]=new int[n][m];
	        for(int i=0;i<m;i++)
	        {
	             if(visit2[n-1][i]==0)
	            dfs(visit2,board,col,row,n-1,i);
	        }
	        for(int i=0;i<n;i++)
	        {
	             if(visit2[i][m-1]==0)
	             dfs(visit2,board,col,row,i,m-1);
	        }
		        List<List<Integer>> al=new ArrayList<List<Integer>>();
		        for(int i=0;i<n;i++)
		        {
		            for(int j=0;j<m;j++)
		            {
		                if(visit[i][j]==1 && visit2[i][j]==1)
		                {
		                   al.add(Arrays.asList(i,j));
		                }
		            }
		        }
		        return al;
	    }
	    static void dfs(int[][] visit, int[][] board, int[] col,int[] row,int r,int c) {
		        visit[r][c] = 1; 
		        int n = board.length;
		        int m = board[0].length;
		        
		        // check for top, right, bottom, left 
		        for(int i = 0;i<4;i++) {
		            int nrow = r + row[i];
		            int ncol = c + col[i]; 
		            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
		            && visit[nrow][ncol] == 0 && board[nrow][ncol]>=board[r][c]) {
		                dfs(visit,board,col,row,nrow,ncol); 
		            }
		        }
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]= {{1,1},{1,1},{1,1}};
       System.out.println(pacificAtlantic(grid));
        
    
	}

}
