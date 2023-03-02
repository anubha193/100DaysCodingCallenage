package day2;
import java.util.*;
public class MinimumElement {
    static Stack<Integer> st=new Stack<>();
   static int min=Integer.MAX_VALUE;
    static int min_val()
    {
	if(st.isEmpty())
		return -1;
	return min;
    }
    static void push(int x)
    {
    if(st.isEmpty())
    	st.push(x);
    else if(min<=x)
    	st.push(x);
    else {
    	st.push(x);
         min=x;
    }
    }
    static int popp()
    {
    	if(st.isEmpty()) return -1; 
        else{
       int popedVal;
      if(st.peek()>=min){
         popedVal = st.peek();
         }else{
            popedVal = min;
             min = 2*min - st.peek(); 
           }
         st.pop();
            return popedVal;
    }
    }
	public static void main(String[] args) {
		push(4);
		push(5);
		push(1);
		push(10);
		push(3);
		System.out.println("minimum val of stack is="+min_val());
		System.out.println("poped value is="+popp());
		push(2);
		System.out.println("minimum val of stack is="+min_val());
		
	}

}
