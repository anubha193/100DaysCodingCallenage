package day1;
import java.util.*;
public class SortAStack {
	 static void sortedInsert(Stack<Integer> s, int x)
	    {
	       
	        if (s.isEmpty() || x > s.peek()) {
	            s.push(x);
	            return;
	        }
	 
	        int temp = s.pop();
	        sortedInsert(s, x);
	 
	      
	        s.push(temp);
	    }
	 
	    
	    static void sortStack(Stack<Integer> s)
	    {
	       
	        if (!s.isEmpty()) {
	           
	            int x = s.pop();
	 
	           
	            sortStack(s);
	 
	            sortedInsert(s, x);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st=new Stack<>();
          st.push(3);
          st.push(2);
          st.push(1);
          sortStack(st);
          System.out.println(st);
	}

}
