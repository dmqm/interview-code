package coding.nowcoder.old;
import java.util.ArrayList;

/*
 * ��Ŀ���� ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */
public class Test51 {
	public class Solution {
		// Parameters:
		// numbers: an array of integers
		// length: the length of array numbers
		// duplication: (Output) the duplicated number in the array number,length of duplication
		// array is 1,so using duplication[0] = ? in implementation;
		// Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
		// ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
		// Return value: true if the input is valid, and there are some duplications in the array
		// number
		// otherwise false
		public boolean duplicate(int numbers[], int length, int[] duplication) {
			boolean[] signal = new boolean[length];
			for (int i = 0; i < length; i++)
				if (signal[numbers[i]] == false)
					signal[numbers[i]] = true;
				else {
					duplication[0] = numbers[i];
					return true;
				}
			return false;
		}
	}
	public class Solution2 {
		// Parameters:
		// numbers: an array of integers
		// length: the length of array numbers
		// duplication: (Output) the duplicated number in the array number,length of duplication
		// array is 1,so using duplication[0] = ? in implementation;
		// Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
		// ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
		// Return value: true if the input is valid, and there are some duplications in the array
		// number
		// otherwise false
		public boolean duplicate(int numbers[], int length, int[] duplication) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < length; i++)
				if (!list.contains(numbers[i]))
					list.add(numbers[i]);
				else {
					duplication[0] = numbers[i];
					return true;
				}
			return false;
		}
	}
}
