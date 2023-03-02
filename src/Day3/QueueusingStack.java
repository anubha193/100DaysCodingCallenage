package Day3;
import java.util.*;
public class QueueusingStack {
     static Stack<Integer> s1=new Stack<>();
     static Stack<Integer> s2=new Stack<>();
     static void push(int data)
     {
    	 s1.push(data);
     }
     static int pop()
     {
    	 if(s1.isEmpty())
    		   return -1;
    		   else
    		   {
    		       while(!s1.isEmpty())
    		       {
    		           s2.push(s1.peek());
    		           s1.pop();
    		       }
    		       int result=s2.peek();
    		       s2.pop();
    		       while(!s2.isEmpty()){
    		           s1.push(s2.peek());
    		           s2.pop();
    		       }
    		       return result;
    		   }
     }
      static int peeked()
      {
    	  if(s1.isEmpty())
   		   return -1;
   		   else
   		   {
   		       while(!s1.isEmpty())
   		       {
   		           s2.push(s1.peek());
   		           s1.pop();
   		       }
   		       int result=s2.peek();
   		       while(!s2.isEmpty()){
   		           s1.push(s2.peek());
   		           s2.pop();
   		       }
   		       return result;
   		   }
      }
	public static void main(String[] args) {
		QueueusingStack q=new QueueusingStack();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
       System.out.println(q.pop());
       System.out.println(q.peeked());
       System.out.println(q.pop());
	}

}
