package offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * 按之字形顺序打印二叉树.
 * 
 * 	请实现一个函数按照之字形打印二叉树，
 * 	即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 	第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * 
 * 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
 * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
 *     1)可用做队列,实现树的层次遍历
 *     2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历

	
 * 
 * @author REN
 * @date 2016年9月9日 下午3:17:10
 */
public class _59PrintTreeInZhi {

	public ArrayList<ArrayList<Integer> > Print2(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		if(root == null){
			return ret;
		}
		
		ArrayList<Integer> list = new ArrayList<>(); //存储每层结果。
		LinkedList<TreeNode> queue = new LinkedList<>(); //节点存储器。
		queue.add(null); //层分隔符
		queue.add(root);
		
		boolean leftToRight = true;
		
		while(queue.size() != 1){
			
			TreeNode node = queue.removeFirst(); //取出队列第一个
			if(node == null){ //层分隔符,遇到层分隔符，则遍历一层。
				//遍历添加
				Iterator<TreeNode> iter = null;
				if(leftToRight){
					iter = queue.iterator(); //正序遍历
				}else{
					iter = queue.descendingIterator(); //倒叙遍历
				}
				while(iter.hasNext()){
					list.add(iter.next().val);
				}
				queue.add(null); //遍历完，添加层分隔符
				ret.add(new ArrayList<Integer>(list)); //添加一层
				list.clear();  //清空list为下一次使用
				leftToRight = !leftToRight; //遍历顺序反转
				continue; //继续下次循环
			}
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
		}
		return ret;
		
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
