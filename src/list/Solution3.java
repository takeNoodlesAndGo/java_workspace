package list;

import java.util.HashMap;

public class Solution3 {
	//һ��������next�����ָ��Ľڵ����null��������hashmap�������Ӧ��ϵ
	//���ȸ���ÿһ���ڵ㣬����ֵnext.����nodeΪ��������nodeΪֵ���б���
	//Ȼ���ͷ����ÿһ���ڵ��random���Ը�ֵ������Ϊmap.get(node).random = map.get(node.random);
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
