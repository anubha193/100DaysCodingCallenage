package day4;
import java.util.*;

class Pair
{ 
	Node node;
	int num;
	public Pair(Node root,Integer n)
	{
	node=root;
	num=n;
	}
}
public class Bst {
      static void answer(Node root,ArrayList<Integer> pre,ArrayList<Integer> in,ArrayList<Integer> post)
      {
    	  Stack<Pair> st=new Stack();
    	  st.push(new Pair(root, 1));
          if (root == null) return;
          while(!st.isEmpty())
          {
        	  Pair it = st.pop();
        	  if(it.num==1)
        	  {
        		pre.add(it.node.data);
        		it.num++;
        		st.push(it);
        		if(it.node.left!=null)
        			st.push(new Pair(it.node.left,1));
        	  }
        	  else if(it.num==2)
        	  {
        		in.add(it.node.data);
        		it.num++;
        		st.push(it);
        		if(it.node.right!=null)
        			st.push(new Pair(it.node.right,1));
        	  }
        	  else
        	  {
        		  post.add(it.node.data);
        		  
        	  }
          }
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(11);
		root.left.right=new Node(12);
		root.right.left=new Node(20);
		root.right.right=new Node(21);
        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> in=new ArrayList<>();
        ArrayList<Integer> post=new ArrayList<>();
        answer(root,pre,in,post);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);


	}

}
