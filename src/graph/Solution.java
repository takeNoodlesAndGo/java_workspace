package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	//��Ŀ:��������ͼ
	//���������������,����ڵ������map�У�ֱ�ӷ��أ�
	//��������ڣ�new һ���ڵ㣬Ȼ��clone �ھӣ�����ھӲ����ڣ��������ȿ�¡��
	private HashMap<Integer,UndirectedGraphNode> map
		= new HashMap<Integer,UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return clone(node);
	}

	private UndirectedGraphNode clone(UndirectedGraphNode node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return null;
		}
		if(map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node.label, newNode);
		for(UndirectedGraphNode neighbor: node.neighbors) {
			if(map.containsKey(neighbor.label)) {
				newNode.neighbors.add(map.get(neighbor.label));
			}else {
				newNode.neighbors.add(clone(neighbor));
			}
		}
		return newNode;
	}
}
