package day10;
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
	}
}
public class ReordeerLinkedList {
	static Node reorderlist(Node head) {
        // Your code here
        if(head==null || head.next==null)return head;
        Node slow=head,fast=head;
       Node pre=null;
        while(fast!=null && fast.next!=null)
        {
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        Node l2= reverse(slow);
        Node l1=head;
      
         while (l1 != null) {
        Node n1 = l1.next, n2 = l2.next;
        l1.next = l2;
        
        if (n1 == null)
          break;
            
        l2.next = n1;
        l1 = n1;
        l2 = n2;
      }
        return head;
    }
    static Node reverse(Node head)
    {  
          Node curr=head;
           Node prev=null;
           Node next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
        
    }
    static void print(Node head)
    {
    	Node temp=head;
    	while(temp!=null)
    	{
    	System.out.print(temp.data+" ");
    	temp=temp.next;
    	}
    	System.out.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Node head=new Node(10);
         head.next=new Node(20);
         head.next.next=new Node(30);
         System.out.println("Original Linked List=");
         print(head);
         System.out.println("Linked List After Reorder=");
         Node list=reorderlist(head);
        	print(list);	 
	}

}
