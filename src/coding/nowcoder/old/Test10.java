package coding.nowcoder.old;
// ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public int RectCover(int target) {
			if (target <= 2)
				return target;
			int res = 2;
			int old = 1, temp;
			for (int i = 2; i < target; i++) {
				temp = res;
				res = res + old;
				old = temp;
			}
			return res;
		}
	}

}
