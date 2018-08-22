package coding.recruit17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 题目描述 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。 例如：如果袋子里面的球的号码是{1,
 * 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。 输入描述:
 * 
 * 第一行输入一个正整数n(n ≤ 1000) 第二行为n个数正整数xi(xi ≤ 1000)
 * 
 * 输出描述:
 * 
 * 输出可以产生的幸运的袋子数
 */
public class T10幸运的袋子 {
	// 别人的方法，加入剪枝
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

		// 思路：DFS生成全组合，同时注意剪枝、避免重复组合
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
				// 回溯恢复状态
				sum -= nums[i];
				multi /= nums[i];
				// 跳过相等的元素，避免重复组合
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
		// 求子序列?
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		getSubHelper(x, list);
		for (ArrayList<Integer> i : list)
			if (isFortune(i))
				res++;
		System.out.println(res);
	}

	// 暴力方法，2^n复杂度，超时了……
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
