package complexity;

public class Solution2 {
	//每个数重复三次，因此所有数的每一个位bit数加起来是3的倍数，
	//因此对应bit的值加起来再模3即为剩余的数字的bit，然后将32位的int数组合起来。
	public int singleNumber(int[] A) {
       int result = 0;
       for(int i =0;i<32;i++) {
    	   int sum = 0;
    	   for(int k =0;k<A.length;k++) {
    		   sum +=  (A[k]>>i)&1;
    	   }
    	   result |= (sum%3)<<i;
       }
       return result;
    }
}
