package complexity;

public class Solution1 {
	//������ֻ��һ��Ԫ��ֻ��һ��������Ԫ�ض�Ϊ�������ҳ���һ��Ԫ�ء�ʹ���������
	 public int singleNumber(int[] A) {
		 int len = A.length;
		 int a = A[0];
		 for(int i=1;i<len;i++) {
			 a ^= A[i];
		 }
		 return a;
	 }
}
