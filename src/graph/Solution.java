package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	//题目:复制无向图
	//首先深度优先搜索,如果节点存在于map中，直接返回，
	//如果不存在，new 一个节点，然后clone 邻居，如果邻居不存在，则进行深度克隆。
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
