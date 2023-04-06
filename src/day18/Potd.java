package day18;
public class Potd {
	 static long no_of_subarrays(int N, int [] arr) {
		//Write your code here
		long count=0;
		long ans=0;
		for(int i=0;i<N;i++)
		{
		    if(arr[i]==0)
		    count++;
		   else
		   {
		        ans =  ans + count*(count+1)/2;
		        count=0;
		   }
		}
		if(count!=0)return  ans + count*(count+1)/2;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] grid= {0, 0, 1, 0};
        System.out.println("number of subarrays is="+no_of_subarrays(grid.length,grid));
	}

}
