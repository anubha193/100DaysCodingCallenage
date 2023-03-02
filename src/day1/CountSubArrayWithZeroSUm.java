package day1;
import java.util.*;
public class CountSubArrayWithZeroSUm {
     static int solve(int[] arr,int n)
     {
    	 int count=0;

    	 int sum=0;

    	 HashMap<Integer ,Integer> map=new HashMap<>();

    	 for(int i=0;i<n;i++)

    	 {

    	 sum=sum+arr[i];

    	 if(sum==0)

    	 {

    	 count++;

    	 }

    	 if(map.containsKey(sum))

    	 {

    	 count=count+map.get(sum);

    	 map.put(sum,map.get(sum)+1);

    	 }

    	 else

    	 {

    	 map.put(sum,1);

    	 }

    	 }

    	 return count;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int arr[]= {0,0,5,5,0,0};
           int n=arr.length;
           System.out.println(solve(arr,n));
	}

}
