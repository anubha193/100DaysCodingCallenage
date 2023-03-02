package day1;
import java.util.*;
public class BasicCalculator {
      static int calculator(String str)
      {
    	  Stack<Integer> st=new Stack<>();
    	  String s=str.trim().replace(" ","");
    	  int number=0,output=0,sign=1;
    	  for(int i=0;i<s.length();i++)
    	  {
    		  char c=s.charAt(i);
    		  if(Character.isDigit(c))
    		  {
    		   number=number*10+(int)(c-'0');
    		  }else if(c=='+')
    		  {
    			  output+=sign*number; 
    			  number=0;
    			  sign=1;
    		  }else if(c=='-')
    		  {
    			  output+=sign*number;  
    			  number=0;
    			  sign=-1;
    		  }
    		 
    		  else if(c=='(')
    		  {
    			  st.push(output);
    			  st.push(sign);
    			  output=0;
    			    sign=1;
    			  }
    		  else if(c==')')
    		  {
    			  output+=sign*number; 
    			  number=0;
    			  output*=st.pop();
    			  output+=st.pop();
    		  }
    		  
    	  }
    	  if(number!=0)
    		  output+=sign*number;
    	  return output;
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 System.out.println(calculator("2-1+2"));

	}

}
