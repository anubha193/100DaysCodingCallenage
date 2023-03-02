package day1;

import java.util.Stack;
 
public class DeleteMiddleOfStack {
     static void solve(Stack<Integer> s1,int n)
     {
    	  int i,size=n/2;
          Stack<Integer> s2=new Stack<>();
        
          for(i=0;i<size;i++) {
              s2.push(s1.peek());
              s1.pop();
          }
         
          s1.pop();
        
          while(!s2.isEmpty()) {
              s1.push(s2.peek());
              s2.pop();
          }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st=new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println(st);
		solve(st,st.size());
		System.out.println(st);
	}

}
