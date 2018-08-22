package coding.nowcoder.old;
/*
 * ��Ŀ����
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
 * ����ʹ�ó�����
 */
public class Test52 {
	public class Solution {
		public int[] multiply(int[] A) {
			int len=A.length;
			int[] B = new int[len];// ���������B[]����
			int[] left=new int[len];
			int[] right=new int[len];
			left[0] = A[0];
			right[len - 1] = A[len - 1];
			for (int i = 1; i < len; i++)
				left[i] = left[i - 1] * A[i];
			for (int i = len - 2; i >= 0; i--)
				right[i] = right[i + 1] * A[i];
			B[0] = right[1];
			B[len - 1] = left[len - 2];
			for (int i = 1; i < len - 1; i++)
				B[i] = left[i - 1] * right[i + 1];
			return B;
		}
	}
}
