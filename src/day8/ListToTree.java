package day8;


import java.util.*;
class ListNode
{
	int data;
	ListNode next;
	ListNode(int data){
	this.data=data;
	}
}
public class ListToTree {
	public static Node sortedListToBST(ListNode head) {
        return listToBST(head, null);
 }
 private static Node listToBST(ListNode head, ListNode tail) {
     if (head == null || head == tail) return null;
     ListNode mid = findMid(head, tail);
     Node root = new Node(mid.data);
     root.left = listToBST(head, mid);
     root.right = listToBST(mid.next, tail);
     return root;
 }
 private static ListNode findMid(ListNode head, ListNode tail) {
     ListNode l1 = head, l2 = head;
     while (l2 != tail && l2.next != tail) {
         l1 = l1.next;
         l2 = l2.next.next;
     }
     return l1;
 }
 static void inorder(Node curr,ArrayList<Integer> al)
 {
	 if(curr==null)return;
	 inorder(curr.left,al);
	 al.add(curr.data);
	 inorder(curr.right,al);
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		ListNode second=new ListNode(2);
		ListNode third=new ListNode(3);
		head.next=second;
		second.next=third;
		third.next=null;
		Node curr=sortedListToBST(head);
		System.out.println("the tree that is made form linked list is");
		 ArrayList<Integer> al=new ArrayList<>();
		inorder(curr,al);
        System.out.println(al);
	}

}
