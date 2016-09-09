package offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *  把二叉树打印成多行.
 *  	从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * 	思路：
 * 		借助ArrayList实现。
 * 
 * @author REN
 * @date 2016年9月9日 下午4:29:28
 */
public class _60PrintTreeInLine {

	 ArrayList<ArrayList<Integer> > Print(TreeNode root) {
		    
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		 if(root == null)
			 return ret;
		 ArrayList<Integer> list = new ArrayList<>();	//存储每一层的遍历结果
		 LinkedList<TreeNode> queue = new LinkedList<>(); //节点遍历器。
		 queue.add(null); //分层标志，添加第一层
		 queue.add(root);
		 while(queue.size()!=1){
			 TreeNode node = queue.removeFirst();
			 if(node == null){
				 Iterator<TreeNode> iter = queue.iterator();
				 while(iter.hasNext()){
					 list.add(iter.next().val);
				 }
				 ret.add(new ArrayList<>(list));
				 list.clear();
				 queue.add(null); //添加层标志
				 continue;
			 }
			 if(node.left != null ){
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
