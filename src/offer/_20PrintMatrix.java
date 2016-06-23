package offer;

import java.util.ArrayList;

/**
 * 题目描述

	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
	如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	
 * @author REN
 * @date 2016年6月23日 下午1:44:13
 */
public class _20PrintMatrix {
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	    
		//矩阵的行数和列数
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		if(rows == 0 || cols == 0)
			return null;
		//矩阵的圈数
		int cicle = ((rows < cols?rows:cols)-1)/2+1;
		
		//按圈添加
		for(int i = 0 ; i< cicle; i++){
			//从左向右添加
			for(int k = i;k<cols-i;k++){
				result.add(matrix[i][k]);
			}
			//从上到下
			for(int l = i+1;l < rows - i;l++){
				result.add(matrix[l][cols-1-i]);
			}
			//从右向左
			for(int m = cols-2-i;m>=i&&(rows-i-1!=i);m--){ //判断这一圈不是只有一列，只有一列，则不添加
				result.add(matrix[rows-1-i][m]);
			}
			
			//从下向上
			for(int n = rows-2-i; n>i && (cols-i-1!=i);n--){ //判断这一圈不是只有一行，只有一行则不添加
				result.add(matrix[n][i]);
			}
		}
		return result;
		
    }
}
