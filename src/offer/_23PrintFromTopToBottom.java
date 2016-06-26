package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * 	题目描述

		从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * 思路：
 * 		借助一个队列。首先把头结点加入队列。从头结点开始遍历，然后分别依次遍历其左右子节点。
 * 		每次遍历完一个结点，就把此节点的左右子结点分别依次加入到队列尾。
 * 		这样依次对队列中的元素进行遍历。直到队列为空结束。
 * 
 * @author REN
 * @date 2016年6月26日 下午12:46:03
 */
public class _23PrintFromTopToBottom {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	 
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		//辅助队列
		LinkedList<TreeNode> quene  = new LinkedList<>();
		
		quene.offer(root);
		while(!quene.isEmpty()){
			
			TreeNode node = quene.poll();//取得队列头
			if(node.left != null){
				quene.offer(node.left);
			}
			if(node.right != null){
				quene.offer(node.right);
			}
			list.add(node.val);
		}
		
		return list;
		
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
