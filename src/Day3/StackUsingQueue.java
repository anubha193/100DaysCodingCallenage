package Day3;
import java.util.*;
public class StackUsingQueue {
	static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
      static void push(int data)
      {
    	  while(!q1.isEmpty())
  	    {
  	        q2.offer(q1.poll());
  	    }
  	    q1.offer(data);
  	    while(!q2.isEmpty())
  	    {
  	        q1.offer(q2.poll());
  	    }
      }
      static int pop()
      {
    	  if(q1.isEmpty())
    		  return -1;
    	  return q1.poll();
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Stack using two Queue");
		StackUsingQueue q=new StackUsingQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
       System.out.println(q.pop());
     
       System.out.println(q.pop());
	}

}
