package offer;
/**
 * 重建二叉树.
 * 题目描述

	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	例如输入前序遍历序列{1,2,4,7,3,5,6,8}
                    和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 * 
 * @author REN
 * @date 2016年6月20日 下午4:59:05
 */
public class _06ReconstructBinaryTree {

public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinary(pre, 0, pre.length-1, in, 0, in.length - 1);
        return root;
    }

public TreeNode reConstructBinary(int[] pre,int startPre,int endPre,int[] in, int startIn,int endIn){
	if(endPre < startPre || endIn < startIn)
		return null;
	TreeNode root = new TreeNode(pre[startPre]); //前序遍历的第一个节点就是根节点。
	for(int i = startIn; i <=endIn; i++){ //在中序遍历中找到根节点，则左侧为左子树，右侧为右子树。递归
		if(in[i] == pre[startPre]){
			root.left = reConstructBinary(pre, startPre+1, startPre + i - startIn, in, startIn, i-1);
			root.right = reConstructBinary(pre, startPre + i -startIn +1, endPre, in, i + 1, endIn);
		}
	}
	return root;
}

/**
 * 二叉树定义
 * @author REN
 * @date 2016年6月20日 下午5:10:28
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
}