package sort;

import java.util.Random;

import org.junit.Test;

public class Solution {
	//��������:ʹ�ò���������������
	//��������ǰһ������������� ��ֻ��Ҫ����һ�����뵽ǰ������������м���
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	public ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode sortNode = head;
		head = head.next;
		sortNode.next = null;
		while(head!=null) {
			ListNode insertNode = sortNode;
			if(head.val<insertNode.val) {
				ListNode nextNode = head.next;//��ʱ������һ���ڵ�
				
				head.next = sortNode;//���������ǽ���ǰ�ڵ���뵽������������
				sortNode = head;
				head = nextNode;
				continue;
			}
			while(insertNode!=null&&insertNode.next!=null) {
				if(insertNode.next.val>head.val) {
					break;
				}
				insertNode = insertNode.next;
			}
			if(insertNode.next==null) { //��һ���ڵ�Ϊ�գ�˵�����뵽���һ���ڵ㼴��
				insertNode.next = head;
				head = head.next;
				insertNode.next.next = null;
			}else {
				ListNode nextNode = head.next;
				head.next = insertNode.next;
				insertNode.next = head;
				head = nextNode;
			}
		}
        return sortNode;
    }
	@Test
	public void testInsertSortList() {//�򵥲��Ժ���
		Random rand = new Random();
		int n = rand.nextInt(1000);
		System.out.println(n);
		ListNode head = new ListNode(n);
		ListNode temp = head;
		int num = 10;
		for(int i = 1;i<num;i++) {
			n = rand.nextInt(1000);
			System.out.println(n);
			temp.next = new ListNode(n);
			temp = temp.next;
		}
		head = insertionSortList(head);
		while(head!=null) {
			System.out.println("�����:"+head.val);
			head = head.next;
		}
	}
}
