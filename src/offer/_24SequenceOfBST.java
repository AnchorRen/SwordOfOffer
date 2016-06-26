package offer;

import java.util.Arrays;

/**
 * 
 * 题目描述

		输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
		如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
	
 * 思路：
 * 		二叉搜索树的特点为：对于任意的父结点和子结点，父结点值大于等于左子树，小于等于右子树。
 * 		
 * 		二叉搜索树的后续遍历，最后一个为头结点root。前面小于头结点的都为左子树，大于头结点的都是右子树。
 * 		对于左子树和右子树，同样用这种方法进行判断。即用递归方法。
 * @author REN
 * @date 2016年6月26日 下午2:00:04
 */
public class _24SequenceOfBST {

	 public boolean VerifySquenceOfBST(int [] sequence) {

		 int length = sequence.length;
		 
		 if(sequence == null||length == 0)
			 return false;
		 
		 //二叉搜索出的后续遍历最后一个结点为根节点。
		 int root = sequence[length - 1];
		 
		 //在二叉搜索树中，左子树的节点小于根节点。此时下标为i的元素为左子树下一个元素。
		 int i = 0;
		 for(; i < length -1 ;i++){
			 if(sequence[i] > root)
				 break;
		 }
		 //判断左子树后面到根节点部分是不是符合右子树大于根节点。
		 int j = i;
		 for(;j<length-1; j++){
			 if(sequence[j] < root)
				 return false;
		 }
		 
		 boolean left=true;
	     boolean right=true;
	     //判断左子树，是不是二叉搜索树
	     if(i>0)
	         left=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
	   
	     //判断右子树，是不是二叉搜索树
	     if(i<sequence.length-1)
	         right=VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
		 
		 return (left&&right);
	 }
}
