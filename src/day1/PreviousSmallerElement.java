package day1;
import java.util.*;
public class PreviousSmallerElement {
       static int[] solve(int[] arr,int n)
       {
    	  int res[]=new int[n];
    	  Stack<Integer> s=new Stack<>();
    	  for(int i=0;i<n;i++)
    	  {
    		  
    		  while(!s.isEmpty() && s.peek()>=arr[i]){

                  s.pop();

              }
    		 if(s.isEmpty())
    			 res[i]=-1;
    		 else
    			 res[i]=s.peek();
    		 s.push(arr[i]);
    		 
    	  }
    	  return res;
       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		int arr[]= {2, 3, 4, 5, 1};
		int n=arr.length;
		int temp[]=solve(arr,n);
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]+" ");
		
	}

}
