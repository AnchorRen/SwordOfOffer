package offer;
/**
 * 题目描述

	一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	
      思路：
	  这道题使用位运算符进行解答。
	 异或（^)运算：两个相同位上的操作数，相同则为0，不同则为1.
	假设这组操作数中只有一个出现了一次，其余的都出现了两次。那么，相同两个数字异或的结果肯定就为0.
	所有数字都进行异或的结果就是这个只出现一次的操作数的值。但是这道题有两个只出现一次的数。由于这两个数
	不同，所以，他们异或的结果肯定就不为0. 那么，我们可以考虑把整个数组分为两个，每一个数组中都包含一个
	只出现一次的数。那么两个数组分别进行异或操作，最终就能找到两个数了。首先需要找到方法把整个数组分为两个
	各包含一个只出现一次数字的子数组。
		可知整个数组异或结果肯定不为0，那么异或结果肯定有一位为1，得到这个1是因为这两个数子在这一位上一个
	为0，一个为1.那么我们可以以异或结果从右向左找到第一次出现1的位的位置。通过分别判断数组中各个数字这一位
	上的数字是否为1把数组分为两个子数组。后面的就简单了！
		
 * @author REN
 */
public class _40FindNumAppearsOnce {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
        	return;
        int firstIndexOf1 = 0;
        int xrResult = 0; //异或结果
        for (int i : array) {
			xrResult ^= i;
		}
        firstIndexOf1 = getFirstIndexOf1(xrResult);
        for(int i = 0;i<array.length;i++){ //分组并异或
        	if(isBit1(array[i], firstIndexOf1))
        		num1[0] ^= array[i];
        	else
        		num2[0] ^= array[i];
        }
    }
	//获得一个数字从右向左第一位为1的位置。
	public int getFirstIndexOf1(int num){
		int index = 0;
		while(((num & 1) == 0) && index < Integer.SIZE * 8){
			num = num >> 1;
			index ++;
		}
		return index;
	}
	//num的第n位是不是1
	public boolean isBit1(int num,int n){
		num = num >> n;
        return (num&1) == 1;
	}
}
