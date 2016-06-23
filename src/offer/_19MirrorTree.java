package offer;

/**
 * 题目描述
 * 
 * 操作给定的二叉树，将其变换为源二叉树的镜像。 输入描述: 二叉树的镜像定义：源二叉树 8 / \ 6 10 / \ / \ 5 7 9 11 镜像二叉树
 * 8 / \ 10 6 / \ / \ 11 9 7 5
 * 
 * @author REN
 * @date 2016年6月23日 下午1:26:12
 */
public class _19MirrorTree {

	public void Mirror(TreeNode root) {

		if(root == null ||(root.right == null && root.left == null)) //結束條件
			return;
		//左右子树交换
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		//递归变换
		if(root.left != null)
			Mirror(root.left);
		if(root.right != null)
			Mirror(root.right);
	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
}
