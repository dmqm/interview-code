package coding.recruit17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*
 * ��Ŀ���� С������һ�첻С��������һ�������Թ�,С����ϣ�����Լ���ʣ������ֵP������������Թ���Ϊ���������,��������һ��n*m�ĸ����Թ�,�Թ�ÿ��λ��Ϊ0����1,0�������λ�����ϰ���,
 * С���ܴﵽ�������λ��;1����С���ܿ��Դﵽ��λ�á�С���ܳ�ʼ��(0,0)λ��,�����Թ��ĳ�����(0,m-1)(��֤������λ�ö���1,���ұ�֤һ������㵽�յ�ɴ��·��),
 * С�������Թ���ˮƽ�ƶ�һ����λ������Ҫ����1������ֵ,������һ����λ������Ҫ����3����λ������ֵ,�����ƶ�����������ֵ,��С���ܵ�����ֵ����0��ʱ��û�е������,С���ܽ��޷������Թ���
 * ������Ҫ�����С���ܼ�����ܷ��ý�ʣ������ֵ�����Թ�(���ﵽ(0,m-1)λ��)�� ��������:
 * 
 * �������n+1��: ��һ��Ϊ��������n,m(3 <= m,n <= 10),P(1 <= P <= 100) ��������n��: ÿ��m��0����1,�Կո�ָ�
 * 
 * �������:
 * 
 * ����������Թ�,�����һ������������С��·��,�����ʽ��������ʾ;������������Թ�,�����"Can not escape!"�� �������ݱ�֤��Ψһ
 */
public class T31�����Թ� {

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

	// ���˵�
	public static class Main {

		static int n, m, maxRemainEnergy = 0;
		static int[][] map;
		static boolean flag = false;
		static String path = "";
		static LinkedList<String> linkedlist = new LinkedList<>();

		public static void main(String[] args) {

			// ����
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

			// ����
			runMap(0, 0, P);

			// ���
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
