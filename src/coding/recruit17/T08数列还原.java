package coding.recruit17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * ��Ŀ���� ţţ����ҵ������һ������Ϊ n ������ A��������а����˴�1��n��n������������ΪһЩԭ��������һЩλ�ã������� 10 �����������ˣ�����ţţ�ǵ��������˳��Ե�������
 * k��˳�����ָ���� i < j �� A[i] < A[j] �Ķ����������ţţ��������������Ҫ��ĺϷ����е���Ŀ�� ��������:
 * 
 * ÿ���������һ������������ÿ�����������ĵ�һ�а����������� n �� k��1 <= n <= 100, 0 <= k <= 1000000000������������ 1 �У����� n �����ֱ�ʾ����
 * A�����е���0�����ʾ�������λ�ã������� 10 ������
 * 
 * �������:
 * 
 * ���һ�б�ʾ�Ϸ���������Ŀ��
 */
public class T08���л�ԭ {
	private static int res = 0;
	private static ArrayList<Integer> fuzzyNum = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Integer>> store = new ArrayList<ArrayList<Integer>>();
	private static int clearOrderCount = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt();
		int[] array = new int[n];
		// ȱʧ��λ��
		ArrayList<Integer> fuzzyPos = new ArrayList<Integer>();
		boolean[] flag = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
			flag[array[i]] = (array[i] != 0);
			if (array[i] == 0)
				fuzzyPos.add(array[i]);
		}
		for (int i = 0; i < n; i++)
			if (array[i] != 0)
				for (int j = i; j < n; j++)
					if (array[j] != 0 && array[i] < array[j])
						clearOrderCount++;
		// ȱʧ������
		System.out.println("clearOrderCount = " + clearOrderCount);
		for (int i = 1; i < flag.length; i++)
			if (!flag[i])
				fuzzyNum.add(i);
		// ������ȫ����
		arrangeHelper(fuzzyPos, 0, k, array);
		System.out.println(res);
	}

	public static void arrangeHelper(ArrayList<Integer> fuzzyPos, int i, int k, int[] array) {
		if (!store.contains(fuzzyPos)) {
			store.add(fuzzyPos);
			if (orderCount(fuzzyPos, array) == k - clearOrderCount)
				res++;
		}
		for (int j = i; j < fuzzyPos.size(); j++) {
			Collections.swap(fuzzyPos, i, j);
			arrangeHelper(fuzzyPos, i + 1, k, array);
			Collections.swap(fuzzyPos, j, i);
		}
	}

	public static int orderCount(ArrayList<Integer> fuzzyPos, int[] array) {
		int res = 0;
		for (int i = 0; i < fuzzyPos.size(); i++)
			array[fuzzyPos.get(i)] = fuzzyNum.get(i);
		for (int i = 0; i < fuzzyPos.size(); i++)
			for (int j = fuzzyPos.get(i) + 1; j < array.length; j++)
				if (array[j] > array[i])
					res++;
		return res;
	}

}
