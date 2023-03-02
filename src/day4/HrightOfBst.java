package day4;

public class HrightOfBst {
     static int height(Node root)
     {
    	if(root==null)
    		return 0;
    	int lh=height(root.left);
    	int rh=height(root.right);
    	return 1+Math.max(lh, rh);
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
		System.out.println(height(root));
	}

}
