package sort;

import java.util.Random;

import org.junit.Test;

public class Solution {
	//问题描述:使用插入排序排序链表
	//插入排序，前一段链表是有序的 ，只需要将后一个插入到前面有序的链表中即可
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
				ListNode nextNode = head.next;//临时保存下一个节点
				
				head.next = sortNode;//下面三行是将当前节点插入到已排序链表中
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
			if(insertNode.next==null) { //后一个节点为空，说明插入到最后一个节点即可
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
	public void testInsertSortList() {//简单测试函数
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
			System.out.println("排序后:"+head.val);
			head = head.next;
		}
	}
}
