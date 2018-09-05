package complexity;

public class Solution1 {
	//数组中只有一个元素只有一个，其他元素都为两个，找出这一个元素。使用异或运算
	 public int singleNumber(int[] A) {
		 int len = A.length;
		 int a = A[0];
		 for(int i=1;i<len;i++) {
			 a ^= A[i];
		 }
		 return a;
	 }
}
