package Day3;

import java.util.Scanner;

public class CircularQueue {
	static int [] q;
	static int capacity;
	static int rear;
	static int front;
			
      public CircularQueue(int n){
    	  capacity=n;
    	  q=new int[n];
    	  front=-1;
    	  rear=-1;
      }
      static void enqueue(int data) {
    	  if((rear+1)%capacity==front) {
    		  System.out.println("Circular Queue if full");
    		  return;
    	  }
    	  if(front==-1)
    		  front=0;
    	  rear=(rear+1)%capacity;
    	  q[rear]=data;
    	
      }
      static int dequeue()
      {
    	  if(front==-1)
    		  return -1;
    	  else
    	  {
    		 int result=q[front];
    		 if(front==rear)
    			 front=rear=-1;
    		 else
    			 front=(front+1)%capacity;
    		 return result;
    	  }
      }
      static int getpeek()
      {
    	  if(front==-1)
      		return -1;
      	return q[front];
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Queue representation by a circular Array");
		System.out.println("enter the capacity of queue=");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		CircularQueue q=new CircularQueue(n);
		q.enqueue(10);
		q.enqueue(5);
		q.enqueue(15);
		q.enqueue(20);
		
		System.out.println("the poped value is="+q.dequeue());
		System.out.println("the peek value of queue="+q.getpeek());

	}

}
