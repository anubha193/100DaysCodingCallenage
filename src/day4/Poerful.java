package day4;
import java.util.*;
public class Poerful {
	 public static int powerfullInteger(int arr[][],int k)
	    {
	        HashMap<Integer,Integer> hm=new HashMap<>();
	        for(int i=0;i<arr.length;i++)
	        {
	            for(int j=0;j<arr[0].length;j++)
	            {      
	                if(hm.containsKey(arr[i][j]))
	                hm.replace(arr[i][j],hm.get(arr[i][j])+1);
	                else
	                hm.put(arr[i][j],1);
	            }
	        }
	        int maxi=Integer.MIN_VALUE;
	        for(int i=0;i<arr.length;i++)
	        {
	            for(int j=0;j<arr[0].length;j++)
	            {      
	               if(hm.get(arr[i][j])>=k)
	            	   maxi=Math.max(maxi, arr[i][j]);
	            }
	        }
	        
	        return maxi;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{1,3},{4,6},{3,4}};
		System.out.println(powerfullInteger(arr,2));

	}

}
