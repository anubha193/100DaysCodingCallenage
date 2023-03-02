package day4;
import java.util.*;
public class SlidingWindowMaximum2 {
        static ArrayList<Integer> sum(int arr[],int k)
        {
        ArrayList<Integer> res=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++)
        pq.add(arr[i]);	
        res.add(pq.peek());
       for(int i=0;i<arr.length-k;i++)
       {
    	 pq.remove(arr[i]);
    	 pq.add(arr[i+k]);
    	 res.add(pq.peek());
       }
        return res;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,-1,-3,5,3,6,7};
		System.out.println(sum(arr,3));
	}

}
