package day17;
import java.util.*;
public class MinimumMultiplicationstoreach {
	static int minimumMultiplications(int[] arr, int start, int end) {
	       Queue<Pair> q=new LinkedList<>();
	       q.add(new Pair(start,0));
	       int dis[]=new int[100000];
	        // Your code here
	        Arrays.fill(dis,(int)Math.pow(10,9));
	           int mod=100000;
	        while(!q.isEmpty())
	        {
	            int node=q.peek().first;
	            int step=q.peek().second;
	            q.poll();
	            for(int i=0;i<arr.length;i++)
	            {
	               int multi=(arr[i]*node)%mod;
	               if(dis[multi]>step+1)
	               {
	                if(multi==end)return step+1;
	               dis[multi]=step+1;
	               q.add(new Pair(multi,step+1));
	               }
	            }
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2, 5, 7};
		int start=3;
		int end=30;
		System.out.println("Minimum Multiplications to reach End is= "+minimumMultiplications(arr,start,end));

	}

}
class Pair
{
    int first;
    int second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
