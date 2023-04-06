package day18;
public class FloydWareshall {
	 public static int[][] shortest_distance(int[][] matrix)
	    {
	        // Code here 
	        int n = matrix.length;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (matrix[i][j]  <0) {
	                    matrix[i][j] = (int)(1e9);
	                }
	                if (i == j) matrix[i][j] = 0;
	            }
	        }

	        for (int k = 0; k < n; k++) {
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < n; j++) {
	                    matrix[i][j] = Math.min(matrix[i][j],
	                                            matrix[i][k] + matrix[k][j]);
	                }
	            }
	        }

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (matrix[i][j] == (int)(1e9)) {
	                    matrix[i][j] = -1;
	                }
	            }
	        }
	        return matrix;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[][] matrix={{0,25},{-1,0}};
     System.out.println("resultant matrix is=");
     int [][]temp=shortest_distance(matrix);
     for(int i=0;i<temp.length;i++)
     {
    	 for(int j=0;j<temp.length;j++)
    	 {
    		 System.out.print(temp[i][j]+" ");
    	 }
    	 System.out.println();
     }
	}

}
