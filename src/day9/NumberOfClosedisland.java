package day9;

public class NumberOfClosedisland {
	  public static int closedIsland(int[][] board) {
		     
	        int m=board[0].length;
	        int n=board.length;
	        int mat[][]=new int[n][m];
	        for(int i=0;i<n;i++)
	        {
	           for( int j=0;j<m;j++)
	           {
	               mat[i][j]=board[i][j];
	           }
	        }
		       int[][] visit=new int[n][m]; 
		        int[] row={1,0,-1,0};
		        int[] col={0,1,0,-1};
		         for(int j = 0 ; j<m;j++) {
		            if(visit[0][j] == 0 && board[0][j] ==0) {
		                dfs(visit,board,col,row,0,j,mat); 
		            }
		            
		            if(visit[n-1][j] == 0 && board[n-1][j] == 0) {
		                dfs(visit,board,col,row,n-1,j,mat); 
		            }
		        }
		        for(int i = 0;i<n;i++) {
		            if(visit[i][0] == 0 && board[i][0] == 0) {
		                dfs(visit,board,col,row,i,0,mat); 
		            }
		            
		            if(visit[i][m-1] == 0 && board[i][m-1] == 0) {
		                dfs(visit,board,col,row,i,m-1,mat); 
		            }
		        }
	        int count=0;
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	                if(mat[i][j]==0 && visit[i][j]==0)
	                {
	                    dfs(visit,board,col,row,i,j,mat);
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	    static void dfs(int[][] visit, int[][] board, int[] col,int[] row,int r,int c,int[][] mat) {
		        visit[r][c] = 1;
	            mat[r][c]=1;
		        int n = board.length;
		        int m = board[0].length;
		        
		        // check for top, right, bottom, left 
		        for(int i = 0;i<4;i++) {
		            int nrow = r + row[i];
		            int ncol = c + col[i]; 
		            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
		            && visit[nrow][ncol] == 0 && board[nrow][ncol] == 0) {
		                dfs(visit,board,col,row,nrow,ncol,mat); 
		            }
		        }
		    }
	    public static void main(String[] args)
	    {
	    	int[][] grid= {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
	    	System.out.println("the number of closed island is= "+closedIsland(grid));
	    }
}
