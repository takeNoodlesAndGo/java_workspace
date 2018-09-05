package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Solution {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {// this question has problems
		ArrayList<String> list = new ArrayList<String>();
		if(s==null||s.length()==0||dict==null||dict.size()==0) {
	        return list;
	    }
		ArrayList<String> temp = new ArrayList<String>();
		iterFindString(list, temp, dict,s);
		return list;
	}
	
	private void iterFindString(ArrayList<String> list, ArrayList<String> temp, Set<String> dict, String s) {
		// TODO Auto-generated method stub
		int len = s.length();
		if(len<1) {
			StringBuffer sb = new StringBuffer();
			for(String str:temp) {
				sb.append(str).append(" ");
			}
			list.add(sb.toString().trim());
			return ;
		}
		for(int i =1;i<=len;i++) {
			String str = s.substring(0, i);
			if(dict.contains(str)) {
				temp.add(str);
				iterFindString(list, temp, dict, s.substring(i));
				temp.remove(temp.size()-1);
			}
		}
	}

	@Test
	 public void testWordBreak() { // this is a test function
		 String s = "catsanddog";
		 Set<String> set = new HashSet<String>();
		 set.add("cats");
		 set.add("cat");
		 set.add("and");
		 set.add("sand");
		 set.add("dog");
		 ArrayList<String> list = wordBreak(s, set);
		 for(int i =0;i<list.size();i++) {
			 System.out.println(list.get(i));
		 }
	 }
	class ListNode {
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
			next = null;
		}
	}
	//对head链表进行排序，选择归并排序
	//1.每次需要找到链表的中点，然后分成左右两边链表
	//2.左右链表进行递归
	//3.对两个链接进行合并
	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode midNode = findMidForm(head);
		ListNode secondNode = midNode.next;
		midNode.next = null;
		head = sortList(head);
		secondNode = sortList(secondNode);
		head = mergeTwoList(head,secondNode);
		return head; 
	}
	public ListNode mergeTwoList(ListNode firstNode, ListNode secondNode) {
		// TODO Auto-generated method stub
		ListNode temp = null;
		ListNode head = null;
		while(firstNode!=null&&secondNode!=null) {
			if(firstNode.val<=secondNode.val) {
				if(head==null) {
					head = firstNode;
				}
				if(temp==null) {
					temp = firstNode;
				}else {
					temp.next = firstNode;
					temp = temp.next;
				}
				firstNode = firstNode.next;
			}else {
				if(head==null) {
					head = secondNode;
				}
				if(temp==null) {
					temp = secondNode;
				}else {
					temp.next = secondNode;
					temp = temp.next;
				}
				secondNode = secondNode.next;
			}
		}
		while(firstNode!=null) {
			if(head==null) {
				head = firstNode;
			}
			if(temp==null) {
				temp = firstNode;
			}else {
				temp.next = firstNode;
				temp = temp.next;
			}
			firstNode = firstNode.next;
		}
		while(secondNode!=null) {
			if(head==null) {
				head = secondNode;
			}
			if(temp==null) {
				temp = secondNode;
			}else {
				temp.next = secondNode;
				temp = temp.next;
			}
			secondNode = secondNode.next;
		}
		return head;
	}

	public ListNode findMidForm(ListNode head) {//求的mid的节点，mid = len/2
		ListNode midNode = null;
		ListNode lastNode = head;
		while(lastNode!=null) {
			lastNode = lastNode.next;
			if(lastNode!=null) {
				lastNode = lastNode.next;
				if(midNode != null) {
					midNode = midNode.next;
				}else {
					midNode = head;
					
				}
			}
		}
		return midNode;
	}
	@Test
	public void testFindMidFrom() {
		int num = 2;
		ListNode list = new ListNode(1);
		ListNode head = list;
		for(int i=2;i<=num;i++) {
			list.next = new ListNode(i);
			list = list.next;
		}
		ListNode midNode = findMidForm(head);
		if (midNode!=null)
			System.out.println(midNode.val);
		else {
			System.out.println("midNode为空");
		}
	}
}
