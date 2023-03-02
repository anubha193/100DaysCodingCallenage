package day2;

public class MaxAreaInAHistogram {
     static int solve(int[] arr,int n)
     {
    	 int area=0;
    	 int max=Integer.MIN_VALUE;
    	 for(int i=0;i<n;i++)
    	 {
    		 int left=i;
    		 int right=i; 
    		 while(left!=0 &&arr[left]>=arr[i])
    			 left--;
    		 while(arr[right]>=arr[i] && right!=n-1)
    			 right++;
    		 area=(right-left-1)*arr[i];
    		 max=Math.max(max, area);
    	 }
    	 return max;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int []arr= {4,2,1,5,6,3,2,4,2};
        int n=arr.length;
        int val=solve(arr,n);
        System.out.println(val);
	}

}
