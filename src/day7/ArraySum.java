package day7;
import java.util.*;
public class ArraySum {
        static void solution(int arr[],int n,int k,int d)
        {
        	if(d==0) {
        	rotateleft(arr,n,k);
        	}
        	else
        		rotateright(arr,n,k);
        }
        static void rotateleft(int arr[],int n,int d)
        {
        	int temp[] = new int[n];
            int k = 0;
            for (int i = d; i < n; i++) {
                temp[k] = arr[i];
                k++;
            }
            for (int i = 0; i < d; i++) {
                temp[k] = arr[i];
                k++;
            }
            for (int i = 0; i < n; i++) {
                arr[i] = temp[i];
            }
        }
        static void rotateright(int arr[],int n,int k)
        {
        	int temp[]=new int[n];
        	int d=0;
        	for(int i=n-k;i<n;i++)
        	{
        		temp[d]=arr[i];
        		d++;
        	}
        	for(int i=0;i<k;i++)
        	{
        		temp[d]=arr[i];
        		d++;
        	}
        	for(int i=0;i<n;i++)
        		arr[i]=temp[i];
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
          System.out.println("Enter the size of Array=");
          int n=sc.nextInt();
          int arr[]=new int[n];
          System.out.println("Enter the element of array=");
          for(int i=0;i<n;i++)
          {
        	  arr[i]=sc.nextInt();
          }
          System.out.println("Enter the number of rotation=");
          int k=sc.nextInt();
          System.out.println("enter 0 if uh rotate want to rotate in left Direction=\n else enter 1");
          int d=sc.nextInt();
          solution(arr,n,k,d);
          System.out.println("output array is=");
          for(int i=0;i<n;i++)
        	  System.out.print(arr[i]+" ");
          
	}

}
