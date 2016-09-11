package offer;
/**
 * 题目描述

	在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 

  输入描述:
	array： 待查找的二维数组
	target：查找的数字
	
	
  输出描述:
	查找到返回true，查找不到返回false

 思路：
 	
 	从矩阵右上角开始遍历，由于数组从左到右递增，从上到下递增，如果当前位置的数大于要查找的数，则向左移动，
 	如果小于要查找的数，则向右移动。
 	
 * @author REN
 * @date 2016年6月12日 下午10:38:23
 */
public class _03FindInPartiallySortedMatrix {

	public class Solution {
	    public boolean Find(int [][] array,int target) {
	    	boolean flag = false;
	    	if(array == null) //数组为空，则返回false
	    		return false;
			int rows = array.length; //二维数组的行数
			int columns = array[0].length; //二位数组的列数
			
			if(rows > 0 && columns >0){ 
				/*
				 * 从右上角开始查找
				 */
				int row = 0; 
				int column = columns - 1; 
				//循环条件，注意符号和数量
				while(row < rows && column >= 0){
					if(array[row][column] == target){
						flag = true;
						break;
					}else if(array[row][column] > target){ //目标数小于二维数组中数，则向左移
						-- column;
					}else{ //大于，则向下移动
						++ row;
					}
						
				}
			}
			return flag;
	    }
	}
}
