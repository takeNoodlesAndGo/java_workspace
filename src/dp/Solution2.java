package dp;

import org.junit.Test;

public class Solution2 {
	//һ���ַ����ָ�ɻ����ַ����������ٵķָ����
	//dp[i]��ʾ0-i-1֮ǰ��Ҫ�ָ����ٵ�����
	public int minCut(String s) {
		if(s==null||s.length()<=1) {
			return 0;
		}
        int[] dp = new int[s.length()+1];//dp[i]��ʾ��i��length-1λ�õ���С�и���
        boolean[][] p = new boolean[s.length()][s.length()];//��ʾp[i][j]�Ƿ����
        dp[s.length()] = -1;
        for(int i =s.length()-1;i>=0;i--) {
        	dp[i] = Integer.MAX_VALUE;//Ϊ���ֵ
        	for(int j =i;j<s.length();j++) {//j��i��ʼ(����i����j)��ÿ�μ���i-j���ַ����Ƿ�ɻ���,����ɻ���������һ���и�
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
