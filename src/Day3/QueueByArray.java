package Day3;
import java.util.*;
public class QueueByArray {
        static int q[];
        static int capacity;
        static int rear;
    public QueueByArray(int n)
    {
    	capacity=n;
    	q=new int[n];
    	rear=-1;
    }
    static void enqueue(int data)
    {
    	if(rear==capacity-1)
    	{
    		System.out.println("Queue is full");
    		return;
    	}
    	rear++;
    	q[rear]=data;
    }
    static int dequeue()
    {
    	if(rear==-1)
    	{
    		return -1;
    	}
    	int result=q[0];
    	for(int i=0;i<rear;i++)
    		q[i]=q[i+1];
    	rear--;
    	return result;
    }
    static int getpeek()
    {
    	if(rear==-1)
    		return -1;
    	return q[0];
    }
	public static void main(String[] args) {
		System.out.println("enter the capacity of queue=");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		QueueByArray q=new QueueByArray(n);
		q.enqueue(10);
		q.enqueue(5);
		q.enqueue(15);
		q.enqueue(20);
		System.out.println("Array representation=");
		System.out.println("the poped value is="+q.dequeue());
		System.out.println("the peek value of queue="+q.getpeek());
	}

}
