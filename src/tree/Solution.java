package tree;

import java.util.ArrayList;

import org.junit.Test;

public class Solution {
	//∫Û–Ú¥Ú”°
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 if(root==null)
			 return list;
		 ArrayList<Integer> left = new ArrayList<Integer>();
		 ArrayList<Integer> right = new ArrayList<Integer>();
		 if(root.left!=null)
			 left = postorderTraversal(root.left);
		 if(root.right!=null)
			 right = postorderTraversal(root.right); 
		 for(int i =0;i<left.size();i++) {
			 list.add(left.get(i));
		 }
		 for(int i =0;i<right.size();i++) {
			 list.add(right.get(i));
		 }
		 list.add(root.val);
		 return list;    
	 }
	 @Test
	 public void testPostorderTraversal() {
		 TreeNode root = new TreeNode(1);
		 TreeNode temp = root;
		 temp.right = new TreeNode(2);
		 temp = temp.right;
		 temp.left = new TreeNode(3);
		 ArrayList<Integer> list = postorderTraversal(root);
		 for(Integer i :list) {
			 System.out.print(i+" ");
		 }
	 }
}
