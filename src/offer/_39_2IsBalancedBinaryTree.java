package offer;

import offer._39TreeDepth.TreeNode;

/**
 * 题目描述

		输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * 思路：
 * 		后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
 * @author REN
 * @date 2016年7月14日 下午10:01:42
 */
public class _39_2IsBalancedBinaryTree {

	boolean isBalance = true;
	
	public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalance;
    }
	
	public int  getDepth(TreeNode node){
		
		if(node == null)
			return 0;
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		if(Math.abs(left - right)>1){
			isBalance = false;
		}
		return left>right ? (left + 1) : ( right + 1);
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
