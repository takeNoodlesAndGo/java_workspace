package list;

public class Solution1 {
	//问题描述:给出一个链表，如果有环的话，返回环开始的节点，如果没有则返回null
	//首先判断环是否存在，判断方法:使用快慢指针，并且速度为2倍且只能为两倍，如果大于两倍则可能跳过
	//有两个等式成立len+b = 2t; a+b = t;消去t可以得到len = 2a+b;因此快指针需要再走a步，慢指针从head开始走，相遇时即为环开始点
	 public ListNode detectCycle(ListNode head) {
		 ListNode slow = head;
		 ListNode fast = head;
		 while(fast!=null&&fast.next!=null) {
			 fast = fast.next.next;
			 slow = slow.next;
			 if(fast==slow) {
				 slow = head;
				 while(fast!=slow) {
					 slow = slow.next;
					 fast = fast.next;
				 }
				 return fast;
			 }
		 }
	     return null;
	 }
}
