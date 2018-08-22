package coding.nowcoder.old;
// ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
public class Test23 {
	public class Solution {
		public boolean VerifySquenceOfBST(int[] sequence) {
			int size = sequence.length;
			if (size == 0)
				return false;
			if (size == 1)
				return true;
			return FoundMid(sequence, 0, size - 1);
		}

		public boolean FoundMid(int[] seq, int left, int right) {
			if (left >= right)
				return true;
			int root = seq[right];
			while (seq[left] < root && left < right) {
				left++;
			}
			int mid = left - 1;
			while (left < right) {
				if (seq[left] < root)
					return false;
				left++;
			}
			return FoundMid(seq, left, mid) && FoundMid(seq, mid + 1, right - 1);
		}
	}
}
