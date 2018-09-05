package tree;

import java.util.ArrayList;

public class Solution1 {
	//Ê÷µÄÇ°Ðò±éÀú
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 if(root==null)
			 return list;
		 list.add(root.val);
		 ArrayList<Integer> left = new ArrayList<Integer>();
		 ArrayList<Integer> right = new ArrayList<Integer>();
		 if(root.left!=null) {
			 left = preorderTraversal(root.left); 
		 }
		 if(root.right!=null) {
			 right = preorderTraversal(root.right);
		 }
		 for(int i=0;i<left.size();i++) {
			 list.add(left.get(i));
		 }
		 for(int i=0;i<right.size();i++) {
			 list.add(right.get(i));
		 }
		 return list;
	 }
}	
