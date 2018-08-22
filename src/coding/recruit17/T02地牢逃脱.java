package coding.recruit17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ��Ŀ���� ����һ�� n �� m �еĵ��Σ����� '.' ��ʾ����ͨ�е�λ�ã�'X' ��ʾ����ͨ�е��ϰ���ţţ�� (x0 , y0 )
 * λ�ó���������������Σ���һ�����Ϸ����ͬ���ǣ���ÿһ��ֻ�ܰ���һЩָ���Ĳ����������Σ�Ҫ��ÿһ���������Գ������εı߽磬Ҳ���ܵ����ϰ��ϡ����εĳ��ڿ���������ĳ������ͨ�е�λ���ϡ�
 * ţţ��֪�������£�����Ҫ���ٲ��ſ����뿪������Ρ� ��������:
 * 
 * ÿ��������� 1 ������������ÿ�����������ĵ�һ�а����������� n �� m��1 <= n, m <= 50������ʾ���εĳ��Ϳ��������� n �У�ÿ�� m ���ַ����������Σ����ν����ٰ�������
 * '.'����������һ�У������������� x0, y0����ʾţţ�ĳ���λ�ã�0 <= x0 < n, 0 <= y0 < m�����Ͻǵ�����Ϊ ��0, 0��������λ��һ����
 * '.'����֮���һ�а���һ������ k��0 < k <= 50����ʾţţ�Ϸ��Ĳ��������������� k �У�ÿ���������� dx, dy ��ʾÿ�ο�ѡ���ƶ����к��в�����-50 <= dx, dy <=
 * 50��
 * 
 * �������:
 * 
 * ���һ��һ�����ֱ�ʾ��������Ҫ���ٴ��ƶ������뿪���Σ������Զ�޷��뿪�����
 * -1�����²��������У�ţţ�������������ƶ��������п�ͨ�е�λ��.�ϣ����γ�����������������½ǣ�ţţ���뿪��Ҫ�ƶ��Ĵ�����࣬Ϊ3�Ρ�
 */
public class T02�������� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {// ע��while������case
			int x = in.nextInt();
			int y = in.nextInt();
			char[][] points = new char[x][y];
			int[][] tar = new int[x][y];
			for (int i = 0; i < x; i++) {
				String str = in.next();
				points[i] = str.toCharArray();
			}
			int startx = in.nextInt();
			int starty = in.nextInt();
			int k = in.nextInt();
			int[] stepx = new int[k];
			int[] stepy = new int[k];
			for (int i = 0; i < k; i++) {
				stepx[i] = in.nextInt();
				stepy[i] = in.nextInt();
			}
			Queue<Integer> xqueue = new LinkedList<Integer>();
			Queue<Integer> yqueue = new LinkedList<Integer>();
			// ���������Ϊ�˱������������Ϊֹ

			xqueue.add(startx);
			yqueue.add(starty);

			tar[startx][starty] = 1; // ��ʼ����ʱ�ǣ�1��ʾ�Ѿ�����
			while (!xqueue.isEmpty() && !yqueue.isEmpty()) {
				startx = xqueue.remove(); // ȡ����
				starty = yqueue.remove();
				for (int i = 0; i < k; i++) {
					if (startx + stepx[i] < x && startx + stepx[i] >= 0 && starty + stepy[i] < y && starty + stepy[i] >= 0) // ������
						if (tar[startx + stepx[i]][starty + stepy[i]] == 0) {
							if (points[startx + stepx[i]][starty + stepy[i]] == '.') {
								tar[startx + stepx[i]][starty + stepy[i]] = tar[startx][starty] + 1;
								xqueue.add(startx + stepx[i]);
								yqueue.add(starty + stepy[i]);
							} else
								tar[startx + stepx[i]][starty + stepy[i]] = -1; // ���ʵ�ΪX
						}
				}
			}
			int max = 0;
			int getRoad = 1;
			for (int i = 0; i < x; i++)
				for (int j = 0; j < y; j++) {
					if (points[i][j] == '.' && tar[i][j] == 0) {
						getRoad = 0; // �д���û�б����ʵġ�.��˵�����ܱ�����ȫ����Щ���ڵ����ˡ�
					}
					max = Math.max(max, tar[i][j]);
				}
			if (getRoad == 0)
				System.out.println(-1);
			else
				System.out.println(max - 1);

		}
	}
}
