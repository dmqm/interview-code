package coding.recruit17;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 题目描述 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，
 * 但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR
 * B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，
 * 所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？ 输入描述:
 * 
 * 第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50) 第二行为n个数xi(1 ≤ xi ≤ 1,000,000,000)，表示需要的各种颜料.
 * 
 * 输出描述:
 * 
 * 输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色。
 */
public class T09混合颜料 {
	// 矩阵秩，极大无关组
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int[] col = new int[n];
			for (int i = 0; i < n; i++) {
				col[i] = scan.nextInt();
			}
			Arrays.sort(col);
			int count = 0;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (highbit(col[i]) == highbit(col[j])) {
						col[j] = col[j] ^ col[i];
					}
				}
				Arrays.sort(col);
			}
			for (int i = 0; i < n; i++)
				if (col[i] != 0) {
					count++;
				}
			System.out.println(count);
		}
	}

	// 最高位
	public static int highbit(int x) {
		for (int i = 31; i >= 0; i--) {
			int m = (x >> i) & 1;
			if (m != 0)
				return i + 1;
		}
		return 0;
	}
}
