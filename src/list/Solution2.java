package list;

public class Solution2 {
	//�ж�һ��list�Ƿ�ɻ�
	//ʹ�õ��ǿ���ָ�뷨
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
