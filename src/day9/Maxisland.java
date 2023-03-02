package day9;

public class Maxisland {
	 public static int maxAreaOfIsland(int[][] grid) {
         if(grid.length == 0 || grid[0].length == 0){
        return 0;    
    }
        int[] roww={1,0,-1,0};
        int[] coll={0,1,0,-1};
    int m = grid.length, n = grid[0].length;
    int max = 0;
    int[] count = new int[1];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1){
                count[0] = 0;
                dfs(grid, i, j, roww, coll, count);       
                max = Math.max(count[0], max);
            }
        }
    }
    return max;
    }
     static void dfs(int[][] image,int row, int col, int delRow[], int delCol[],int[] count) {
        image[row][col] = 0; 
        int n = image.length;
        int m = image[0].length; 
         count[0]++;
        for(int i = 0;i<4;i++) {
            int nrow = row + delRow[i]; 
            int ncol = col + delCol[i]; 
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && 
            image[nrow][ncol] == 1) {
                dfs(image,nrow, ncol, delRow, delCol, count); 
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] grid= { {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0}
                        ,{0,1,0,0,1,1,0,0,1,1,1,0,0},
                       {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
       System.out.println("the maximum island size is="+maxAreaOfIsland(grid));
	}

}
