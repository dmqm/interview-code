package coding.nowcoder;

import java.util.ArrayList;

/*
 * ��Ŀ���� ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 */
public class T24�������к�Ϊĳһֵ��·�� {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
			ArrayList<ArrayList<Integer>> des = new ArrayList<ArrayList<Integer>>();
			ThroughPath(root, target, null, des);
			return des;
		}
		public void ThroughPath(TreeNode root, int target, ArrayList<Integer> now, ArrayList<ArrayList<Integer>> des) {
			ArrayList<Integer> list;
			if (now != null)
				list = new ArrayList<Integer>(now);
			else
				list = new ArrayList<Integer>();
			if (root != null) {
				list.add(root.val);
				if (root.val == target && root.left == null && root.right == null) {
					des.add(list);
				} else {
					ThroughPath(root.left, target - root.val, list, des);
					ThroughPath(root.right, target - root.val, list, des);
				}
			}
		}
	}
}
