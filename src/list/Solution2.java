package list;

public class Solution2 {
	//判断一个list是否成环
	//使用的是快慢指针法
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow) {
				return true;
			}
		}
        return false;
    }
}
