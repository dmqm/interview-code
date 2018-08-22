package coding.nowcoder.old;
// HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
// ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
// ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��(�������ĳ���������1)
public class Test30 {
	public class Solution {
		public int FindGreatestSumOfSubArray(int[] array) {
			if (array.length <= 1)
				return array[0];
			int res = array[0], sum = array[0];
			for (int i = 1; i < array.length; i++) {
				if (sum > 0)
					sum += array[i];
				else
					res = array[i];
				sum = Math.max(res, sum);

			}
			return res;

		}
	}
	public class Solution2 {
		public int FindGreatestSumOfSubArray(int[] array) {
			int res = array[0]; // ��¼��ǰ����������ĺ͵����ֵ
			int max = array[0]; // ����array[i]�������������ֵ
			for (int i = 1; i < array.length; i++) {
				max = Math.max(max + array[i], array[i]);
				res = Math.max(max, res);
			}
			return res;
		}
	}
}
