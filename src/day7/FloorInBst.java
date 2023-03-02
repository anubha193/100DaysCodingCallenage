package day7;

public class FloorInBst {
	 static int search(Node root,int x)
     {
  	   int res=-1;
  	   while(root!=null)
  	   {
  		if(root.data==x)return root.data;
  		if(x>root.data) {
  			res=root.data;
  			root=root.right;
  		}
  		else {

  			root=root.left;
  	   }
  	   }
  	   return res;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root=new Node(40);
	   		root.left=new Node(30);
	   		root.right=new Node(50);
	   		root.left.left=new Node(20);
	   		root.left.right=new Node(35);
	   		root.right.left=new Node(45);
	   		root.right.right=new Node(60);
	   		System.out.println(search(root,55));
	   		

	}
}
