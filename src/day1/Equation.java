package day1;
import java.util.*;
public class Equation {
      static void solve(int arr[],int n)
      {
    	
    	
    	 for(int i=0;i<n;i++)
    	 {
    		 for(int j=i+1;j<n;j++)
    		 {
    			 System.out.println(i+" "+j);
    			 System.out.println(arr[i]+arr[j]);
    			
    		 }
    	 }
   
    		
   
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int arr[]= {3, 4, 7, 1, 2, 9, 8};
         int n=arr.length;
         solve(arr,n);
        
	}

}
