package day5;
import java.util.*;
class Pair
{
	Node node;
	int num;
	public Pair(Node root,int val)
	{
		node=root;
		num=val;
	}
}
public class MaximumWidthOfBst {
        static int result(Node root)
        {
        	if(root == null) return 0;
            int ans = 0;
            Queue<Pair> q = new LinkedList<>(); 
            q.offer(new Pair(root, 0)); 
            while(!q.isEmpty()){
                int size = q.size();
                int mmin = q.peek().num;   
                int first = 0,last = 0;
                for(int i=0; i<size; i++){
                    int cur_id = q.peek().num-mmin;
                    Node node = q.peek().node;
                    q.poll();
                    if(i==0) first = cur_id;
                    if(i==size-1) last = cur_id;
                    if(node.left != null)
                        q.offer(new Pair(node.left, cur_id*2+1));
                    if(node.right != null) 
                        q.offer(new Pair(node.right, cur_id*2+2));
                }
                ans = Math.max(ans, last-first+1);
            }
            return ans;
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
		System.out.println("The width of tree is="+result(root));
	}

}
