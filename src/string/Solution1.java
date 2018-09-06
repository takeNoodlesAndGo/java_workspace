package string;

import java.util.ArrayList;

import org.junit.Test;

public class Solution1 {
	//palindrome-partitioning 回文字符串分割
	//题目要求:将字符串分割为回文字符串，求所有的可能
	//采用深度优先求解
	private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	private ArrayList<String> tempList = new ArrayList<String>();
	public ArrayList<ArrayList<String>> partition(String s) {
        dfs(s);
        return list;
    }
	public void dfs(String s) {
		if(s==null||s.equals("")) {
			ArrayList temp = (ArrayList) tempList.clone();
			if(temp.size()!=0) {
				list.add(temp);
			}
			return ;
		}
		for(int i=1;i<=s.length();i++) {
			String temp = s.substring(0, i);
			if(isPalindrome(temp)) {
				tempList.add(temp);
				dfs(s.substring(i));
				tempList.remove(tempList.size()-1);
			}
		}
	}
	private boolean isPalindrome(String s) {
		int begin = 0;
		int end = s.length()-1;
		char[] chs = s.toCharArray();
		while(begin<=end) {
			if(chs[begin]!=chs[end]) {
				return false;
			}
			begin++;
			end--;
		}
		return true;
	}
	@Test
	public void testPartition() {
		String s = "aab";
		partition(s);
		for(ArrayList<String> l: list) {
			for(String ss: l) {
				System.out.print(ss+" ");
			}
			System.out.println();
		}
	}
}
