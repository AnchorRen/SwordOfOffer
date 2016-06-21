package offer;

/**
 * 题目描述

		输入两颗二叉树A，B，判断B是不是A的子结构。
 * 
 * 
 * @author REN
 * @date 2016年6月21日 下午9:33:09
 */
public class _18DoesTreeHaveTree {

	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        
		if(root2 == null || root1 == null) //有任意一个为null，则不存在
			return false;
		
		return isSubTree(root1, root2)||HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2);
    }
	
	public boolean isSubTree(TreeNode root1, TreeNode root2){
		//结束条件
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		
		if(root1.val == root2.val){
			return isSubTree(root1.left, root2.left)&&isSubTree(root1.right, root2.right);
		}
		return false;
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
