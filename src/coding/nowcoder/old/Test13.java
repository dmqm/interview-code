package coding.nowcoder.old;
// ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
public class Test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public void reOrderArray(int[] array) {
			int index1 = 0, index2 = 0, temp;
			while (index2 < array.length) {
				if (array[index2] % 2 == 0)
					index2++;
				else {
					temp = array[index2];
					for (int i = index2; i > index1; i--)
						array[i] = array[i - 1];
					array[index1] = temp;
					index1++;
					index2++;

				}
			}
		}
	}

}
