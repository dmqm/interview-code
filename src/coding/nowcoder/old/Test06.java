package coding.nowcoder.old;
// ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
// ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
public class Test06 {

	public class Solution {
		public int minNumberInRotateArray(int[] array) {
			if (array.length == 0)
				return 0;
			if (array.length == 1)
				return array[1];
			for (int i = 0; i < array.length - 1;) {
				if (array[i] > array[++i])
					return array[i];
			}
			return array[1];
		}
	}

}
