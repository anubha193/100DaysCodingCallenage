package day9;

public class FloodFill {
	 static int[][] floodFill(int[][] image, int sr, int sc, int color) {
	      int[][] ans=image;
	        int clr=image[sr][sc];
	        int delRow[]={-1, 0, +1, 0};
	        int delCol[] = {0, +1, 0, -1};
	        dfs(sr,sc,ans,image,color,delRow,delCol,clr);
	        return ans;
	    }
	     static void dfs(int row, int col, 
	     int[][] ans,
	     int[][] image, 
	     int newColor, int delRow[], int delCol[],
	     int iniColor) {
	        // color with new color
	        ans[row][col] = newColor; 
	        int n = image.length;
	        int m = image[0].length; 
	        for(int i = 0;i<4;i++) {
	            int nrow = row + delRow[i]; 
	            int ncol = col + delCol[i]; 
	            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && 
	            image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
	                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor); 
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]= {{1,1,1},{1,1,0},{1,0,1}};
		int sc=1;
		int sr=1;
		int clr=2;
		int dis[][]=floodFill(grid,sr,sc,clr);
		System.out.println("the matrix is filled by color=");
		 for(int i=0;i<dis.length;i++)
	        {
	        	for(int j=0;j<dis[0].length;j++)
	        	{
	        		System.out.print(dis[i][j]+" ");
	        	}
	        	System.out.println();
	        }
		

	}

}
