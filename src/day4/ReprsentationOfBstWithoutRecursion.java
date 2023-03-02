package day4;
import java.util.*;
class  Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data=data;
	}
	}
public class ReprsentationOfBstWithoutRecursion {
	static void preorder2(Node root)
	{
		Stack<Node> st=new Stack<>();
		st.push(root);
		while(!st.isEmpty())
		{
			Node curr=st.pop();
			System.out.print(curr.data+"->");
		
			if(curr.right!=null)
			{
				st.push(curr.right);
			}
			if(curr.left!=null)
			{
				st.push(curr.left);
			}
		}
	}
	    static void inorder2(Node root)
	    {
	    	Stack<Node> st=new Stack<>();
	    	while(true)
	    	{
	    		if(root!=null)
	    		{
	    			st.push(root);
	    			root=root.left;
	    		}
	    		else
	    		{
	    			if(st.isEmpty())
	    				break;
	    		
	    		root=st.pop();
	    		System.out.print(root.data+"->");
	    		root=root.right;
	    		}
	    	}
	    }
	    static void postorder2(Node root)
	    {
	    	Stack<Node> s1=new Stack<>();
	    	Stack<Node> s2=new Stack<>();
			s1.push(root);
			while(!s1.isEmpty())
			{
				Node curr=s1.pop();
				s2.push(curr);
			
				if(curr.left!=null)
				{
					s1.push(curr.left);
				}
				if(curr.right!=null)
				{
					s1.push(curr.right);
				}
			}
			while(!s2.isEmpty())
			{
				System.out.print(s2.pop().data+"->");
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
		
		System.out.println("\n1-preorder is=");
		preorder2(root);
		
		System.out.println("\n2-inorder is=");
		inorder2(root);
		
		System.out.println("\n3-postorder is=");
		postorder2(root);
	}}

