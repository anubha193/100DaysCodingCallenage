package day5;
import java.util.*;
public class IsPrimeTwoNumber {
     static boolean possible(int n)
     {
    	 int start=1;
    	 int end=n-1;
    	 while(start<=end)
    	 {
    		 if(isPrime(start) && isPrime(end))
    		 {
    			 return true;
    		 }
    		 else
    		 {
    			 start++;
    			 end--;
    		 }
    	 }
    	 return false;
     }
     static boolean isPrime(int n)
     {
    	 for(int i=2;i*i<=n;i++)
    	 {
    		 if(n%i==0)return false;
    	 }
    	 return true;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of a=");
       int a=sc.nextInt();
       if(possible(a))
    	   System.out.println("Yes");
       else
    	   System.out.println("No");
	}

}
