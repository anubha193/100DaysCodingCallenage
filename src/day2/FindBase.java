package day2;
import java.util.*;
public class FindBase {
	 static void base(int n,int m,String s)
	 {
		 if(n/m==1)
			 return;
		 base(n/m,m,s+Integer.toString(n/m));
	 }
     public static void main(String[] args)
     {
    	 System.out.println("enter number");
    	Scanner sc=new Scanner(System.in);
    			int n=sc.nextInt();
    			String s="";
    			base(n,2,s);
    			System.out.println(s);
     }
}
