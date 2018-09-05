package string;

import org.junit.Test;

public class Solution {
	//TODO：继续写kmp算法
	//kmp算法实现，具体详见 http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
	public String strStr(String haystack, String needle) {
		if(needle==null||haystack==null||needle.length()==0) {
			return haystack;
		}
		if(needle.length()>haystack.length()) {
			return null;
		}
		char[] hays = haystack.toCharArray();
		char[] nees = needle.toCharArray();
		int[] arr = getPartMatch(needle);
		int lenHay = haystack.length();
		int lenNee = needle.length();
		int i = 0;
		int j = 0;
		while(i<lenHay&&j<lenNee) {
			if(j==-1||hays[i]==nees[j]) {
				i++;
				j++;
			}else {
				j = arr[j];
			}
		}
		if(j==lenNee) {
			return haystack.substring(i-lenNee);
		}else {
			return null;
		}
	}
	//getNext数组的求法，见https://www.cnblogs.com/tangzhengyue/p/4315393.html
	public int[] getPartMatch(String needle) {
		// TODO Auto-generated method stub
		int len = needle.length();
		int[] arr = new int[len];
		char[] chs = needle.toCharArray();
		int j = 0;
		int k = -1;
		arr[0] = -1;
		while(j<len-1) {
			if(k==-1||chs[j]==chs[k]) {
				arr[++j] = ++k;
			}else {
				k = arr[k];
			}
		}
		return arr;
	}
	@Test
	public void testStrStr() {
		String haystack = "BBCABCDABABCDABCDABDE";
		String needle = "ABCDABD";
		String result = strStr(haystack, needle);
		if(result==null) {
			System.out.println(needle+"不存在");
		}else {
			System.out.println(result);
		}
	}
}
