package day8;
import java.util.Scanner;
public class NumberOfProvision {
	 public static int findCircleNum(int[][] M) {
	       int N = M.length;
	        boolean[]visited = new boolean[N];
	        int count = 0;
	        
	        for(int i = 0; i < N ;i++){
	            if(!visited[i]){
	                count++;
	                dfs(M,i,visited);
	            }
	        }
	      return count;  
	    }
	 static void dfs(int[][]M,int i,boolean[]visited){
	        for(int j = 0 ; j < M[i].length ; j++){
	            if(!visited[j] && M[i][j] != 0){
	                visited[j] = true;
	                dfs(M,j,visited);
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	     
	     System.out.println("Enter the number of nodes in the Graph=");
	     int n=sc.nextInt();
	     int[][] matrix=new int[n+1][n+1];
	     System.out.println("Enter the number of Edges in the graph=");
	     int m=sc.nextInt();
	     matrix(matrix,m,n);

	}
	 static void matrix(int[][] matrix,int m,int n)
     {
   	  Scanner sc=new Scanner(System.in);
   	 for(int i=0;i<m;i++)
   	{
       System.out.println("enter the node values for "+(i+1)+"th node");
   	System.out.println("enter the value of first node");
   	int first=sc.nextInt();
   	System.out.println("enter the value of second node");
   	int second=sc.nextInt();
   	matrix[first-1][second-1]=1;
    matrix[second-1][first-1]=1;
       
   	}
   	System.out.println("the number of provision in  graph is");
    System.out.println(findCircleNum(matrix));
     }

}
