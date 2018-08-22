package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。 输入描述:
 * 
 * 输入为一个整数，即为圆半径的平方,范围在32位int范围内。
 * 
 * 输出描述:
 * 
 * 输出为一个整数，即为优雅的点的个数
 */
public class T22优雅的点 {
	// 超时……
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			long sqr = in.nextInt();
			int r = (int) Math.sqrt(sqr);
			int res = 0;
			for (int x = 1; x <= r; x++) {
				int limit = (int) Math.sqrt(sqr - x * x);
				for (int y = 0; y <= limit; y++)
					if (x * x + y * y == sqr)
						res += 4;
			}
			System.out.println(res);
		}
	}

	// 别人的
	public static class Main {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int rSquare = in.nextInt();
			int count = 0;
			double r = Math.sqrt(rSquare);

			// 存储值
			for (int i = 0; i < r; i++) {
				/*
				 * 运行超时 for(int j=1;j<r+1;j++){ if(i*i+j*j==rSquare){ count++; } }
				 */
				// 优化点1
				double j = Math.sqrt(rSquare - i * i);
				if ((int) j == j) {
					count++;
				}
			}

			// 优化点2
			System.out.print(count << 2);

		}
	}

}
