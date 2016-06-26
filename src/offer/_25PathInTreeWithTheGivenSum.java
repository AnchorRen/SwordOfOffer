package offer;

import java.util.ArrayList;

/**
 * 题目描述

	输入一颗二叉树和一个整数，
	打印出二叉树中结点值的和为输入整数的所有路径。
	路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 *  
 * 
 * @author REN
 * @date 2016年6月26日 下午2:30:14
 */
public class _25PathInTreeWithTheGivenSum {

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
        if(root==null)return paths;
        find(paths,new ArrayList<Integer>(),root,target);
        return paths;
    }
    public void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
        path.add(root.val);
        
        //到达叶节点，判断这边路径是否符合
        if(root.left==null&&root.right==null){
            if(target==root.val){
                paths.add(path);
            }
            return;
        }
        
        //复制一个路径
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        
        //对于每一条从根节点都叶节点的路径，都用一个ArrayList存储。
        
        if(root.left!=null)
        	find(paths,path,root.left,target-root.val);
        
        if(root.right!=null)
        	find(paths,path2,root.right,target-root.val);
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
