package coding.nowcoder.old;
// ���������Ķ�����������任ΪԴ�������ľ���
public class Test18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public class Solution {
	    public void Mirror(TreeNode root) {
	        if(root!=null) {
	        	TreeNode temp=root.left;
	        	root.left=root.right;
				root.right = temp;
				Mirror(root.left);
				Mirror(root.right);
	        }
	    }

	}
}