package day4;
import java.util.*;
public class SlidingWindowMaximum3 {
         static ArrayList<Integer> sum(int[] arr,int k)
         {
        	Deque<Integer> dq=new ArrayDeque<>();
        	ArrayList<Integer> al=new ArrayList<>();
        	for(int i=0;i<arr.length;i++)
        	{
        		 if(!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
        	        while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
        		dq.offer(i);
        		if(i>=k-1)al.add(arr[dq.peek()]);
        	}
        	return al;
         }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,-1,-3,5,3,6,7};
		System.out.println(sum(arr,3));

	}

}
