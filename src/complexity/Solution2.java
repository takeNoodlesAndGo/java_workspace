package complexity;

public class Solution2 {
	//ÿ�����ظ����Σ������������ÿһ��λbit����������3�ı�����
	//��˶�Ӧbit��ֵ��������ģ3��Ϊʣ������ֵ�bit��Ȼ��32λ��int�����������
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
