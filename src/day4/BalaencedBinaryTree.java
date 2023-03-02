package day4;

public class BalaencedBinaryTree {
	static int ans=0;
	 static int height(Node root)
     {
    	if(root==null)
    		return 0;
    	int lh=height(root.left);
    	int rh=height(root.right);
    	if(lh==-1 || rh==-1)return -1;
    	if(Math.abs(lh-rh)>1)return -1;
    	return 1+Math.max(lh, rh);
     }
	 static int daimeter(Node root)
     {
    	if(root==null)
    		return 0;
    	int lh=daimeter(root.left);
    	int rh=daimeter(root.right);
    	ans=Math.max(ans,rh+lh);
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
		
		System.out.println(daimeter(root));
		System.out.println(ans);
		if(height(root)==-1)System.out.println("Tree is balanced");
		else
			System.out.println("Tree is unbalanced");
	}
}
