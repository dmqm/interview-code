package coding.nowcoder;

/*
 * 题目描述 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class T61序列化二叉树 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	public class Solution {
		int index = -1;

		String Serialize(TreeNode root) {
			if (root == null)
				return "#,";
			StringBuffer res = new StringBuffer();
			res.append(root.val + ",");
			res.append(Serialize(root.left));
			res.append(Serialize(root.right));
			return res.toString();
		}

		TreeNode Deserialize(String str) {
			String[] array = str.split(",");
			TreeNode node = DeserializeHelper(array);
			return node;
		}

		TreeNode DeserializeHelper(String[] array) {
			index++;
			TreeNode node = null;
			if (!"#".equals(array[index])) {
				node = new TreeNode(Integer.valueOf(array[index]));
				node.left = DeserializeHelper(array);
				node.right = DeserializeHelper(array);
			}
			return node;
		}

	}
}
