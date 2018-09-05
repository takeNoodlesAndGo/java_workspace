package list;

import java.util.HashMap;

public class Solution3 {
	//一个链表含有next和随机指向的节点或者null，这里用hashmap来保存对应关系
	//首先复制每一个节点，并赋值next.并以node为键，复制node为值进行保存
	//然后对头部的每一个节点的random属性赋值。方法为map.get(node).random = map.get(node.random);
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null) {
			return null;
		}
		RandomListNode node = head;
		RandomListNode copyNode = new RandomListNode(head.label);
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		map.put(node, copyNode);
		while(node.next!=null) {
			copyNode.next = new RandomListNode(node.next.label);
			node = node.next;
			copyNode = copyNode.next;
			map.put(node, copyNode);
        }
		RandomListNode copyHead = map.get(head);
		node = head;
		while(node!=null) {
			map.get(node).random = map.get(node.random);
			node = node.next;
		}
		return copyHead;
		
    }
}
