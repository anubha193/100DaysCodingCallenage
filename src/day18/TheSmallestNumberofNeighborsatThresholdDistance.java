package day18;

public class TheSmallestNumberofNeighborsatThresholdDistance {
	 static int findCity(int n, int m, int[][] mat,int dis)
    {
        int[][] matrix=new int[n][n];
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++)
              matrix[i][j] = Integer.MAX_VALUE;
      }
        for(int i=0;i<m;i++)
        {
            matrix[mat[i][0]][mat[i][1]]=mat[i][2];
             matrix[mat[i][1]][mat[i][0]]=mat[i][2];
        }
    
     for (int i = 0; i < n; i++) matrix[i][i] = 0;
      for (int k = 0; k < n; k++) {
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                   if (matrix[i][k] == Integer.MAX_VALUE ||
                          matrix[k][j] == Integer.MAX_VALUE)
                      continue;
                  matrix[i][j] = Math.min(matrix[i][j],
                                          matrix[i][k] + matrix[k][j]);
              }
          }
      }
      int cntCity = n;
      int cityNo = -1;
          for(int i=0;i<n;i++)
          {
              int count=0;
              for(int j=0;j<n;j++)
              {
                 if(matrix[i][j]<=dis)
                 {
                   count++;  
                 }
              }
               if (count <= cntCity) {
              cntCity = count;
              cityNo = i;
          }
          }
          return cityNo;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		int n=4,m=4;
		int[][] grid= {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		int dis= 4;
		System.out.println("City With the Smallest Number of Neighbors at a Threshold Distance="+findCity(n,m,grid,dis));
	}

}
