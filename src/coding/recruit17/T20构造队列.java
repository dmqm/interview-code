package coding.recruit17;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 题目描述 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * 
 * while(!Q.empty()) //队列不空，执行循环
 * 
 * {
 * 
 * int x=Q.front(); //取出当前队头的值x
 * 
 * Q.pop(); //弹出当前队头
 * 
 * Q.push(x); //把x放入队尾
 * 
 * x = Q.front(); //取出这时候队头的值
 * 
 * printf("%d\n",x); //输出x
 * 
 * Q.pop(); //弹出这时候的队头
 * 
 * }
 * 
 * 做取出队头的值操作的时候，并不弹出当前队头。
 * 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正] 输入描述:
 * 
 * 第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
 * 
 * 输出描述:
 * 
 * 对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
 */
public class T20构造队列 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			int[] src = new int[T];
			for (int i = 0; i < T; i++)
				src[i] = in.nextInt();
		}
	}

	// 别人的方法……
	/*
	 * 思想：先使用一个1到n的数组模拟小明的操作， 然后会得到一组输出，例如：3,5,10,7.... 按题意是应该输出 1,2,3,4.... 这样，我们就可以反推出 1应该在第3个位置
	 * 2应该在第5个位置 3应该在第10个位置 4应该在第7个位置
	 */
	public static class Main {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int number = scanner.nextInt();
			while (number-- > 0) {
				int n = scanner.nextInt();
				helper(n);
			}
		}

		public static void helper(int n) {
			// 生成一个1-n的数组
			LinkedList<Integer> original = new LinkedList<Integer>();
			for (int i = 1; i <= n; i++) {
				original.addLast(i);
			}

			// 模拟过程
			LinkedList<Integer> res = new LinkedList<Integer>();
			while (!original.isEmpty()) {
				int x = original.removeFirst();
				original.addLast(x);
				x = original.removeFirst();
				res.addLast(x);
			}

			// 反推出正确位置，放入out数组中
			int[] out = new int[n];
			for (int i = 1; i <= n; i++) {
				int x = res.removeFirst();
				out[x - 1] = i;
			}

			// 输出out数组
			System.out.print(out[0]);
			for (int i = 1; i < n; i++) {
				System.out.print(" " + out[i]);
			}
			System.out.println();
		}
	}

}
