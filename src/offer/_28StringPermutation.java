package offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * 题目描述

		输入一个字符串,按字典序打印出该字符串中字符的所有排列。
		例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
		abc,acb,bac,bca,cab和cba。 #结果请按字母顺序输出#
	
 * 
 * @author REN
 * @date 2016年6月28日 上午10:19:15
 */
public class _28StringPermutation {

	public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
 
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res); //排列结果，按顺序输出
        }
        return res;
    }
	/**
	 * 递归交换
	 * @param cs
	 * @param i
	 * @param list
	 */
    private static void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
        if(i == cs.length - 1) { //字符串最后一个节点，则不需要交换了。
            list.add(String.valueOf(cs)); 
        } else {
            for(int j = i; j < cs.length; ++j) {
                if(j == i || cs[j] != cs[i]) {
                    swap(cs, i, j);
                    PermutationHelper(cs, i + 1, list); //递归
                    swap(cs, i, j); //复位
                }
            }
        }
    }
    
    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
