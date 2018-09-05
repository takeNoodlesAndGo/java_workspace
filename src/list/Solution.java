package list;

public class Solution {
	 public void reorderList(ListNode head) {
		 if(head==null||head.next==null) {
			 return ;
		 }
		 ListNode fast = head;
		 ListNode slow = head;
		 while(fast.next!=null&&fast.next.next!=null) {
			 fast = fast.next.next;
			 slow = slow.next;
		 }
		 ListNode after = slow.next;
		 slow.next = null;
		 ListNode pre = null;
		 while(after!=null) {
			 ListNode temp = after.next;
			 after.next = pre;
			 pre = after;
			 after = temp;
		 }
		 ListNode first = head;
		 while( first!= null && pre!=null) {
			 ListNode firsttemp = first.next;
			 ListNode secondtemp = pre.next;
			 first.next = pre;
			 pre.next = firsttemp;
			 first = firsttemp;
			 pre = secondtemp;
		 }
	 }
}
