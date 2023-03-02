package day2;
import java.util.*;
public class Histogram {
   static int[] solve(int hist[],int n)
   {
	   int[] nextSmaller = new int[n];

       Stack<Integer> s = new Stack<>();


       for(int i = n-1; i >= 0; i--){

           while(!s.isEmpty() && hist[i] <= hist[s.peek()]){

               s.pop();

           }

           if(s.isEmpty()){

               nextSmaller[i] = n;

           }else{

               nextSmaller[i] = s.peek();

           }

           s.push(i);

       }

       return nextSmaller;
   }
   static int[] solve2(int[] arr,int n)
   {
	   int[] temp = new int[n];
      Stack<Integer> s = new Stack<>();
       for(int i = 0; i < n; i++){
          while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
        	  s.pop();
          }
          if(s.isEmpty()){   
        	  temp[i] = -1;
          }else{
        	  temp[i] = s.peek();
          }
          s.push(i);
       }
          return temp;
       }
   static int result(int[] arr,int n)
   {
	   int left[]=solve2(arr,n);
	   int right[]=solve(arr,n);
	   int area=0;
	   int max=Integer.MIN_VALUE;
	   for(int i=0;i<n;i++)
	   {
		   area=(right[i]-left[i]-1)*arr[i];
		   max=Math.max(max, area);
	   }
	   return area;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int arr[]= {1,1,0,0,1,1};
          int n=arr.length;
        int val=result(arr,n);
        System.out.println(val);
	}

}
