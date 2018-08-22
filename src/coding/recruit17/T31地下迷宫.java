package coding.recruit17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*
 * 题目描述 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,
 * 小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),
 * 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。
 * 现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。 输入描述:
 * 
 * 输入包括n+1行: 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100) 接下来的n行: 每行m个0或者1,以空格分隔
 * 
 * 输出描述:
 * 
 * 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 */
public class T31地下迷宫 {

	static int n = 0, m = 0;
	static LinkedList<Integer> path = new LinkedList<Integer>();
	static int[][] map;
	static boolean[][] flag;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			n = in.nextInt();
			m = in.nextInt();
			int P = in.nextInt();
			map = new int[n][m];
			flag = new boolean[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					map[i][j] = in.nextInt();
			path.add(0);
			path.add(0);
			if (tryEscape(0, 0, P)) {
				StringBuilder sb = new StringBuilder();
				ListIterator<Integer> it = path.listIterator();
				if (it.hasNext()) {
					sb.append("[" + it.next() + "," + it.next() + "],");
				}
				System.out.println(sb.toString().substring(0, sb.length() - 1));
			} else
				System.out.println("Can not escape!");

		}
	}

	public static boolean tryEscape(int x, int y, int remainP) {
		if (remainP < 0 || x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 0 || flag[x][y])
			return false;
		path.add(x);
		path.add(y);
		flag[x][y] = true;
		System.out.println("in tryEscape(" + x + "," + y + "," + remainP + ")");
		if (x == 0 && y == m - 1)
			return true;
		boolean res = tryEscape(x + 1, y, remainP - 1) || tryEscape(x - 1, y, remainP - 1) || tryEscape(x, y + 1, remainP - 3) || tryEscape(x, y - 1, remainP);
		if (res)
			return res;
		path.removeLast();
		path.removeLast();
		flag[x][y] = false;
		return res;

	}

	// 别人的
	public static class Main {

		static int n, m, maxRemainEnergy = 0;
		static int[][] map;
		static boolean flag = false;
		static String path = "";
		static LinkedList<String> linkedlist = new LinkedList<>();

		public static void main(String[] args) {

			// 输入
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			int P = sc.nextInt();
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 处理
			runMap(0, 0, P);

			// 输出
			if (!flag)
				System.out.println("Can not escape!");
			else
				System.out.println(path);

		}

		public static synchronized void runMap(int x, int y, int energy) {
			if (energy < 0 || x < 0 || y < 0 || x >= n || y >= m || map[x][y] != 1)
				return;
			else {
				linkedlist.offer("[" + x + "," + y + "]");
				map[x][y] = 0;
				if (x == 0 && y == m - 1) {
					if (energy >= maxRemainEnergy) {
						maxRemainEnergy = energy;
						updatePath();
					}
					map[x][y] = 1;
					linkedlist.removeLast();
					flag = true;
					return;
				}
				runMap(x, y + 1, energy - 1);
				runMap(x + 1, y, energy);
				runMap(x - 1, y, energy - 3);
				runMap(x, y - 1, energy - 1);
				map[x][y] = 1;
				linkedlist.removeLast();
			}
		}

		public static void updatePath() {
			StringBuilder sb = new StringBuilder();
			Iterator<String> iterator = linkedlist.iterator();
			while (iterator.hasNext())
				sb.append(iterator.next() + ",");
			if (sb.length() > 0)
				sb.deleteCharAt(sb.length() - 1);
			path = sb.toString();
		}

	}
}
