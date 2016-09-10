package offer;
/**
 * 二叉搜索树的第k个结点.
 * 
 * 	给定一颗二叉搜索树，请找出其中的第k小的结点。
 *  例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 
 *  思路：
 *  	按照中序遍历顺序打印出每个节点，就是从小到大的顺序。
 *  	所以找到中序遍历的第k个结点就是结果。
 *  	
 * @author REN
 * @date 2016年9月10日 上午9:48:30
 */
public class _62KthNode {

	int index = 0; //计算器。
	
	TreeNode KthNode(TreeNode root, int k)
    {
		if(root != null){//中序遍历寻找第k个。
			TreeNode node = KthNode(root.left,k);
			if(node != null) //排除null干扰
				return node;
			index ++;
			if(index == k)
				return root;
			node = KthNode(root.right,k);
			if(node != null)
				return node;
		}
		return null;
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
