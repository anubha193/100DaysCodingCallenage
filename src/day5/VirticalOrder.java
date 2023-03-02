package day5;
import java.util.*;
class Tuple {
    Node node;
    int row;
    int col;
    public Tuple(Node _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}
public class VirticalOrder {
	
	 public static List < List < Integer >> findVertical(Node root) {
	        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
	        Queue < Tuple > q = new LinkedList < Tuple > ();
	        q.offer(new Tuple(root, 0, 0));
	        while (!q.isEmpty()) {
	            Tuple tuple = q.poll();
	           Node node = tuple.node;
	            int x = tuple.row;
	            int y = tuple.col;


	            if (!map.containsKey(x)) {
	                map.put(x, new TreeMap < > ());
	            }
	            if (!map.get(x).containsKey(y)) {
	                map.get(x).put(y, new PriorityQueue < > ());
	            }
	            map.get(x).get(y).offer(node.data);

	            if (node.left != null) {
	                q.offer(new Tuple(node.left, x - 1, y + 1));
	            }
	            if (node.right != null) {
	                q.offer(new Tuple(node.right, x + 1, y + 1));
	            }
	        }
	        List < List < Integer >> list = new ArrayList < > ();
	        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
	            list.add(new ArrayList < > ());
	            for (PriorityQueue < Integer > nodes: ys.values()) {
	                while (!nodes.isEmpty()) {
	                    list.get(list.size() - 1).add(nodes.poll());
	                }
	            }
	        }
	        return list;
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
		System.out.println("Virtical order traversal of tree=");
		List<List<Integer>> al=findVertical(root);
		System.out.println(al);

	}
}


