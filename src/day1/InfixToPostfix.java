package day1;
import java.util.*;
public class InfixToPostfix {
      static String solve(String sb)
      {
    	  String out="";
    	  String str=sb.trim().replace(" ", "");
    	  Stack<Character> st = new Stack<>();
    	  for(int i=0;i<str.length();i++)
    	  {
    		  char s=str.charAt(i);
    		 
    		 if(isPrec(s)>0)
    		  {
    			  while (!st.empty() && isPrec(s)<=isPrec(st.peek())){
    				  out+=st.peek();
                     st.pop();
                 }

                 st.push(s);       
    		  }
    		  else if(s=='('|| s==')')
    		  {
    			  if (st.empty())
                      st.push(s);
                  else{
                      while (s == ')') {
                          if (st.peek()=='('){
                              st.pop(); break;}
                          out+=st.peek();
                          st.pop();

                      }
                      if (s == '(')
                          st.push(s);
                  }

              } 
    		  else
    		  {
    			  out+=str.charAt(i);
    		  }
    		  }
    	  
    	  while(!st.isEmpty())
    	  {
    		  out+=st.peek();
              st.pop(); 
    	  }
    	  return out;
      }
      public static int isPrec(char ch){
          int p=0;
          switch (ch){
              case '+': case '-':
                  p=1;
                  break;
              case '*': case '/':
                  p=2;
                  break;
              case '^' :
            	  p=3;
            	  break;  
              case '(': case ')':
                  p=0;
                  break;
              default:
                  p=-1;   
          }
          return p;
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=solve("(1+(4+5+2)-3)+(6+8)");
         System.out.println(str);
         result(str);
	}
	static void result(String str)
	{
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(c>='0'&& c<='9')
				st.push(Integer.parseInt(String.valueOf(c)));
			else
			{
				int a=st.pop();
				int b=st.pop();
				if(c=='+')
					st.push(a+b);
				else if(c=='-')
					st.push(a-b);
				else if(c=='*')
					st.push(a*b);
					else if(c=='/')
						st.push(a/b);
			}
			
		}
		System.out.println(st.peek());
	}

}
