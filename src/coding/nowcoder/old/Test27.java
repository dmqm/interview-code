package coding.nowcoder.old;

import java.util.ArrayList;
import java.util.Collections;

// ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
public class Test27 {
	// ���֡���������
	public class Solution {
		public ArrayList<String> Permutation(String str) {
			ArrayList<String> des = new ArrayList<String>();
			if (str != null && str.length() > 0)
				PermutationHelper(str.toCharArray(), 0, des);
			Collections.sort(des);
			return des;
		}

		private void PermutationHelper(char[] charArray, int i, ArrayList<String> des) {
			if (i == charArray.length - 1) {
				String val = String.valueOf(charArray);
				if (!des.contains(val))
					des.add(val);
			}
			for (int j = i; j < charArray.length; j++) {
				swap(charArray, i, j);
				PermutationHelper(charArray, i + 1, des);
				swap(charArray, i, j);
			}
		}

		private void swap(char[] charArray, int i, int j) {
			char t = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = t;
		}


	}
}
