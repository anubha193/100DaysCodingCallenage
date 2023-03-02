package day2;

public class LargestAreaSubmatrix {
     static int solve(int arr[][])
     {
    	 int n=arr.length;
    	 int m=arr[0].length;
    	 int a[]=arr[0];
    	 Histogram hs=new Histogram();
    	 int max=hs.result(a,a.length);
    	 int ans=0;
    	 for(int i=1;i<n;i++)
    	 {
    		 for(int j=0;j<m;j++)
    		 {
    			 if(arr[i][j]==1)
    				 a[j]++;
    			 else
    				 a[j]=0;
    				 
    		 }
    		 ans=hs.result(a,a.length);
    		 max=Math.max(ans,max);
    		 
    	 }
    	 return max;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[][]= {{0 ,1, 1, 0},
    	         {1, 1, 1, 1},
    	         {1, 1, 1, 1},
    	         {1, 1, 0, 0}};
       System.out.println(solve(arr));
       
	}

}
