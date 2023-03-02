package day5;
import java.util.*;
public class BoundaryTraversal {
        static void lefttraversal(Node root,ArrayList<Integer> al)
        {
        	Node curr=root.left;
        	while(curr!=null)
        	{
        		if(isLeaf(curr)==false)al.add(curr.data);
        		if(curr.left!=null)curr=curr.left;
        		else
        			curr=curr.right;
        	}
        }
        static void leaf(Node root,ArrayList<Integer> al)
        {
        	if(isLeaf(root)==true) {
        		al.add(root.data);
        		return;
        	}
        	if(root.left!=null)leaf(root.left,al);
        	if(root.right!=null)leaf(root.right,al);
        }
        static void righttraversal(Node root,ArrayList<Integer> al)
        {
        	Stack<Integer> s=new Stack<>();
        	Node curr=root.right;
        	while(curr!=null)
        	{
        		if(isLeaf(curr)==false)s.push(curr.data);
        		if(curr.right!=null)curr=curr.right;
        		else
        			curr=curr.left;
        	}
        	while(!s.isEmpty())
        	{
        		al.add(s.peek());
        		s.pop();
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
		ArrayList<Integer> al=new ArrayList<>();
		System.out.println("Boundry Traversal of tree=");
		if(root==null) System.out.println("tree is empty");
		if(isLeaf(root)==false)
			al.add(root.data);
		lefttraversal(root,al);
		leaf(root,al);
		righttraversal(root,al);
		System.out.println(al);
	}
	static boolean isLeaf(Node root) {
		// TODO Auto-generated method stub
		if(root.left==null && root.right==null)
		return true;
		return false;
	}

}
