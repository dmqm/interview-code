package coding.recruit17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * ��Ŀ���� һ������������n����ÿ�������涼��һ������(ӵ����ͬ����������������)�����һ�����������˵ĵ��ҽ���������ĺ���ĺʹ���������ĺ���Ļ��� ���磺��������������ĺ�����{1,
 * 1, 2, 3}��������Ӿ������˵ģ���Ϊ1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * ������ʵ��Ӵ������Ƴ�һЩ��(�����Ƴ�0��,���Ǳ��Ƴ���)��Ҫʹ�Ƴ���Ĵ��������˵ġ����������̼���һ������Ի�õĶ����ֲ�ͬ�����˵Ĵ��ӡ� ��������:
 * 
 * ��һ������һ��������n(n �� 1000) �ڶ���Ϊn����������xi(xi �� 1000)
 * 
 * �������:
 * 
 * ������Բ��������˵Ĵ�����
 */
public class T10���˵Ĵ��� {
	// ���˵ķ����������֦
	public static class Main {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNextInt()) {
				int n = scanner.nextInt();
				int[] nums = new int[n];
				for (int i = 0; i < n; i++)
					nums[i] = scanner.nextInt();

				Arrays.sort(nums);
				System.out.println(find(nums, 0, 0, 1));
			}
		}

		// ˼·��DFS����ȫ��ϣ�ͬʱע���֦�������ظ����
		private static int find(int[] nums, int index, long sum, long multi) {
			int count = 0;
			for (int i = index; i < nums.length; i++) {
				sum += nums[i];
				multi *= nums[i];
				if (sum > multi)
					count += 1 + find(nums, i + 1, sum, multi);
				else if (nums[i] == 1)
					count += find(nums, i + 1, sum, multi);
				else
					break;
				// ���ݻָ�״̬
				sum -= nums[i];
				multi /= nums[i];
				// ������ȵ�Ԫ�أ������ظ����
				while (i < nums.length - 1 && nums[i] == nums[i + 1])
					i++;
			}
			return count;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> x = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			x.add(in.nextInt());
		int res = 0;
		// ��������?
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		getSubHelper(x, list);
		for (ArrayList<Integer> i : list)
			if (isFortune(i))
				res++;
		System.out.println(res);
	}

	// ����������2^n���Ӷȣ���ʱ�ˡ���
	public static void getSubHelper(ArrayList<Integer> x, ArrayList<ArrayList<Integer>> list) {
		if (!list.contains(x))
			list.add(x);
		for (int i = 0; i < x.size(); i++) {
			ArrayList<Integer> sub = new ArrayList<>(x);
			sub.remove(i);
			getSubHelper(sub, list);
		}
	}

	public static boolean isFortune(ArrayList<Integer> x) {
		int sum = 0, muti = 1;
		for (int i : x) {
			sum += i;
			muti *= i;
		}
		return sum > muti;
	}

}
