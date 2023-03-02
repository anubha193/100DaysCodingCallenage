package day5;
import java.util.*;
public class PrintRootToLeaf {
       static ArrayList<Integer> result(Node root,int val)
       {
    	   ArrayList<Integer> al=new ArrayList<>();
    	   if(root==null)return al;
    	   ans(root,val,al);
    	   return al;
       }
       static boolean ans(Node root,int val,ArrayList<Integer> al)
       {
    	   if (root == null)
               return false;

           al.add(root.data);

           if (root.data == val)
               return true;

           if (ans(root.left,val,al) ||
               ans(root.right, val,al))
               return true;   
           al.remove(al.size() - 1);
           return false;
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
		System.out.println("path is=");
		System.out.println(result(root,21));
	}

}
