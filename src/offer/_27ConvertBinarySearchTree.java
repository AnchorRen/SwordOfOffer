package offer;
/**
 * 	题目描述：

		输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
		要求不能创建任何新的结点，只能调整树中结点指针的指向。
		
	解题思路：
		
		1.将左子树构造成双链表，并返回链表头节点。
		2.定位至左子树双链表最后一个节点。
		3.如果左子树链表不为空的话，将当前root追加到左子树链表。
		4.将右子树构造成双链表，并返回链表头节点。
		5.如果右子树链表不为空的话，将该链表追加到root节点之后。
		6.根据左子树链表是否为空确定返回的节点。
 * 
 * @author REN
 * @date 2016年6月28日 上午9:34:34
 */
public class _27ConvertBinarySearchTree {

	public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root; 
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
