package day5;


import java.util.*;

public class LeftRightView {
       static ArrayList<Integer> left(Node root)
       {
    	   ArrayList<Integer> al=new ArrayList<>();
           if(root==null)return al;
           foundleft(root,0,al);
           return al;
       }
       static void foundleft(Node root,int level,List<Integer> al)
       {
           if(root==null)return ;
           if(level==al.size())
               al.add(root.data);
           foundleft(root.left,level+1,al);
           foundleft(root.right,level+1,al);
       }
       static ArrayList<Integer> right(Node root)
       {
    	   ArrayList<Integer> al=new ArrayList<>();
           if(root==null)return al;
           foundright(root,0,al);
           return al; 
       }
       static void foundright(Node root,int level,List<Integer> al)
       {
           if(root==null)return ;
           if(level==al.size())
               al.add(root.data);
           foundright(root.right,level+1,al);
           foundright(root.left,level+1,al);
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
		System.out.println(left(root));
		System.out.println(right(root));
	}

}
