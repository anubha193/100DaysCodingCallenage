package day7;
import java.util.*;
public class FlattenABinaryTree {
      static void morries(Node root)
      {
    	  Node curr=root;
    	  while(curr!=null)
    	  {
    		  if(curr.left!=null)
    		  {
    			  Node prev=curr.left;
    			  while(prev.right!=null)
    				  prev=prev.right;
    			  prev.right=curr.right;
    			  curr.right=curr.left;
    		  }
    		  curr=curr.right;
    	  }
      }
      
      static Node prev = null;
      static void flattenr(Node  root) {
        if (root == null) return;

        flattenr(root . right);
        flattenr(root . left);

        root . right = prev;
        root . left = null;
        prev = root;
      }
      public static void flatten(Node root)
      {
       Stack<Node> s=new Stack();
       s.push(root);
       while(!s.isEmpty())
       {
           Node curr=s.peek();
           s.pop();
           if(curr.right!=null)
           s.push(curr.right);
           if(curr.left!=null)
           s.push(curr.left);
            if (!s.isEmpty()) {
        curr . right = s.peek();
      }
      curr . left = null;
       }
      }
      static void print(Node root)
      {
    	  Node curr=root;
    	  while(curr!=null)
    	  {
    		  System.out.print(curr.data+" ");
    		  curr=curr.right;
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
	   		Node curr=root;
	   		morries(root);
	   		print(root);

	}

}
