package day9;

public class CountSubIsland {
	 public static int countSubIslands(int[][] grid1, int[][] grid2) {
	      int n=grid1.length;
	        int m=grid1[0].length;
	        int[][] mat=new int[n][m];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	                if(grid1[i][j]==1 && grid2[i][j]==1)
	                    mat[i][j]=1;
	                else
	                    mat[i][j]=0;
	            }
	        }
	        int visit[][]=new int[n][m];
	        int[] row={1,0,-1,0};
	        int[] col={0,1,0,-1};
	        int count=0;
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	                System.out.print(mat[i][j]+" "); 
	            }
	            System.out.println();
	            }
	     
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	             	 if(visit[i][j]==0 && mat[i][j]==1) {
	             		   count++;
	             		 dfs(visit,mat,col,row,i,j);
	             	 }
	            }
	        }
	        return count;
	        
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
	            && visit[nrow][ncol] == 0 && board[nrow][ncol] == 1) {
	                dfs(visit,board,col,row,nrow,ncol); 
	            }
	        }
	    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid1[][]= {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
		int grid2[][]= {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
		System.out.println(countSubIslands(grid1,grid2));

	}

}
