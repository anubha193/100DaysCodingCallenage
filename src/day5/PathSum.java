package day5;

public class PathSum {
    static boolean path(Node root,int sum)
    {
    	if(root==null)return false;
    	if(root.left==null && root.right==null && root.data==sum)return true;
    	sum=sum-root.data;
    	return (path(root.left,sum)|| path(root.right,sum));
    }
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(11);
		root.left.right=new Node(12);
		root.right.left=new Node(20);
		root.right.right=new Node(21);
		System.out.println(isLeaf(root));
		if(path(root,15))
			System.out.println("YES!,sum is exist in the tree");
		else
			System.out.println("No!,sum is not exist in the tree");
	}
	static boolean isLeaf(Node root) {
		// TODO Auto-generated method stub
		if(root.left==null)
		return true;
		return false;
	}

}
