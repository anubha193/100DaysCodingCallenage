package day9;
public class Surroundregion {
	 public static char[][] solve(char[][] board) {
	        int n=board.length;
	        int m=board[0].length;
	        char[][] mat=new char[n][m];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	             	mat[i][j]=board[i][j]; 
	            }
	        }
	       int[][] visit=new int[n][m]; 
	        int[] row={1,0,-1,0};
	        int[] col={0,1,0,-1};
	         for(int j = 0 ; j<m;j++) {
	            if(visit[0][j] == 0 && board[0][j] == 'O') {
	                dfs(visit,board,col,row,0,j); 
	            }
	            
	            if(visit[n-1][j] == 0 && board[n-1][j] == 'O') {
	                dfs(visit,board,col,row,n-1,j); 
	            }
	        }
	        for(int i = 0;i<n;i++) {
	            if(visit[i][0] == 0 && board[i][0] == 'O') {
	                dfs(visit,board,col,row,i,0); 
	            }
	            
	            if(visit[i][m-1] == 0 && board[i][m-1] == 'O') {
	                dfs(visit,board,col,row,i,m-1); 
	            }
	        }
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	             	 if(visit[i][j]==0 && board[i][j]=='O')
	             		 mat[i][j]='X';
	            }
	        }
	        return mat;
	        
	    }
	   static void dfs(int[][] visit, char[][] board, int[] col,int[] row,int r,int c) {
	        visit[r][c] = 1; 
	        int n = board.length;
	        int m = board[0].length;
	        
	        // check for top, right, bottom, left 
	        for(int i = 0;i<4;i++) {
	            int nrow = r + row[i];
	            int ncol = c + col[i]; 
	            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
	            && visit[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
	                dfs(visit,board,col,row,nrow,ncol); 
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char[][] mat=solve(board);
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

	}

}
