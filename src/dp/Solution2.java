package dp;

import org.junit.Test;

public class Solution2 {
	//一个字符串分割成回文字符串，求最少的分割次数
	//dp[i]表示0-i-1之前需要分割最少刀术数
	public int minCut(String s) {
		if(s==null||s.length()<=1) {
			return 0;
		}
        int[] dp = new int[s.length()+1];//dp[i]表示从i到length-1位置的最小切割数
        boolean[][] p = new boolean[s.length()][s.length()];//表示p[i][j]是否回文
        dp[s.length()] = -1;
        for(int i =s.length()-1;i>=0;i--) {
        	dp[i] = Integer.MAX_VALUE;//为最大值
        	for(int j =i;j<s.length();j++) {//j从i开始(包含i包含j)，每次计算i-j的字符串是否成回文,如果成回文则增加一次切割
        		if(s.charAt(i)==s.charAt(j)&&(j-i<2||p[i+1][j-1])) {
        			p[i][j] = true;
        			dp[i] = Math.min(dp[i], dp[j+1]+1);
        		}
        	}
        }
        return dp[0];
    }
	@Test
	public void testMinCut() {
		String str = "abcdefg";
		System.out.println(minCut(str));
	}
}
