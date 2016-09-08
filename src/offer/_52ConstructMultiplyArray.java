package offer;
/**
 * 构建乘积数组
		给定一个数组A[0,1,...,n-1],
		请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * 思路：
   分两步：1.计算前i - 1个元素的乘积，及后N - i个元素的乘积分别保存在两个数组中。这可以用动态规划实现。
        2.计算B[i]的值
 * 
 * @author REN
 * @date 2016年9月8日 上午11:13:01
 */
public class _52ConstructMultiplyArray {

	public int[] multiply(int[] A) {

	        int len = A.length;
	        int forword[] = new int[len];
	        int backword[] = new int[len];
	        int B[] = new int[len];
	        forword[0] = 1; //乘积的基数
	        backword[0] = 1;
	        for(int i = 1;i < len; i++){
	            forword[i] = A[i - 1]*forword[i-1]; //数组每一项表示前 i-1个元素的乘积
	            backword[i] = A[len - i]*backword[i - 1]; //数组每一项表示后 n-i 个元素的乘积
	        }
	        // forword[i] 表示前i-1个元素 乘积， backword[i] 表示A 最后的i个元素的乘积。后n-i 个元素的乘积为backword[len - i -1]
	        for(int i = 0; i < len; i++){
	            B[i] = forword[i] * backword[len - i -1]; //前 i-1 个乘积 与 后 n-i个乘积相乘
	        }
	        return B;
    }
}
