package day4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.*;

public class BottamView {
	public static List<Integer> bottamview(Node root)
	{
	 ArrayList<Integer> al=new ArrayList<>();
	 TreeMap<Integer,Integer> hm=new TreeMap<>();
	 Queue<Pairr> q=new  LinkedList<>();
	 if(root==null)return al;
	 q.offer(new Pairr(root,0));
	 while(!q.isEmpty())
	 {
		Pairr it=q.remove() ;
		int val=it.line;
		Node node=it.node;
		if(hm.get(val)==null)hm.put(val, node.data);
		if(hm.containsKey(val))
			hm.replace(val, node.data);
		if(node.left!=null)
			q.offer(new Pairr(node.left,val-1));
		if(node.right!=null)
			q.offer(new Pairr(node.right,val+1));
	 }
	 for(Map.Entry<Integer ,Integer> entry:hm.entrySet())
	 {
		al.add(entry.getValue()) ;
	 }
	 return al;
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
	   System.out.println(bottamview( root));

	}

}
