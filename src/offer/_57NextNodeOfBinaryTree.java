package offer;

/**
 * 二叉树的下一个结点
 * 
 * 题目描述
 * 
 * 		给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。 
 * 		注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * 思路：
 * 		先画图，找规律。可以分为两种情况。
 * 		<1>.如果该结点有右子树，则右子树的最左节点为下一个节点。
 * 		<2>.如果该结点无右子树，则找到当前节点是其父节点的的左孩子的结点。就是下一个节点
 * 			如果找到根节点仍未找到，则该结点为中序遍历的最后一个节点，下一个节点为NUll。
 * 
 * @author REN
 * @date 2016年9月9日 上午11:29:05
 */
public class _57NextNodeOfBinaryTree {

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		////如果有右子树，则找右子树的最左节点
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null)
				pNode = pNode.left;
			return pNode;
		}
		//没有右子树，则找当前节点是其父节点的左孩子的结点
		while(pNode.next != null){
			if(pNode.next.left == pNode)
				return pNode.next;
			pNode = pNode.next;
		}
		//退到了根节点仍没找到，则这个节点是最右节点。则返回null
		return null; 
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}
}
