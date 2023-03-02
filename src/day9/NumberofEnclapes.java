package day9;
public class NumberofEnclapes {
	 static int numberOfEnclaves(int[][] board) {
         int n=board.length;
	        int m=board[0].length;
	       int[][] visit=new int[n][m]; 
	        int[] row={1,0,-1,0};
	        int[] col={0,1,0,-1};
	         for(int j = 0 ; j<m;j++) {
	            if(visit[0][j] == 0 && board[0][j] ==1) {
	                dfs(visit,board,col,row,0,j); 
	            }
	            
	            if(visit[n-1][j] == 0 && board[n-1][j] == 1) {
	                dfs(visit,board,col,row,n-1,j); 
	            }
	        }
	        for(int i = 0;i<n;i++) {
	            if(visit[i][0] == 0 && board[i][0] == 1) {
	                dfs(visit,board,col,row,i,0); 
	            }
	            
	            if(visit[i][m-1] == 0 && board[i][m-1] == 1) {
	                dfs(visit,board,col,row,i,m-1); 
	            }
	        }
	        int count=0;
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	             	 if(visit[i][j]==0 && board[i][j]==1)
	             	   count++;
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
        int[][] grid = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        System.out.println("the number of enclapes is= "+numberOfEnclaves(grid));
	}

}
