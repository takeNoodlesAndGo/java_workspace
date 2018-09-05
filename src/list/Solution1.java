package list;

public class Solution1 {
	//��������:����һ����������л��Ļ������ػ���ʼ�Ľڵ㣬���û���򷵻�null
	//�����жϻ��Ƿ���ڣ��жϷ���:ʹ�ÿ���ָ�룬�����ٶ�Ϊ2����ֻ��Ϊ��������������������������
	//��������ʽ����len+b = 2t; a+b = t;��ȥt���Եõ�len = 2a+b;��˿�ָ����Ҫ����a������ָ���head��ʼ�ߣ�����ʱ��Ϊ����ʼ��
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
