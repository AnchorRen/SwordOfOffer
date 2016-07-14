package offer;
/**
 * 
 * 题目描述

		输入一棵二叉树，求该树的深度。
		从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路：
 * 		如果一棵树只有左子树，那么树的深度等于左子树深度加1；对右子树同理。
 * 如果左右子树都不为空，则分别遍历左右子树，树的深度等于左右子树中深度最大者加1。
 * 所以，可以使用递归解答。
 * @author REN
 * @date 2016年7月14日 下午9:43:03
 */
public class _39TreeDepth {

	public int TreeDepth(TreeNode pRoot){
		if(pRoot == null)
			return 0;
		int pLeft = TreeDepth(pRoot.left);
		int pRight = TreeDepth(pRoot.right);
		
		return pLeft > pRight ? (pLeft + 1):(pRight + 1);
    }
	
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
	        this.val = val;
	    }
	};
}
