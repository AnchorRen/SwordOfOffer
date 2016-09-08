package offer;
/**
 * 
 * 计算两个数字的和，不能使用加减乘除运算符。
 * 
 * 思路：
 * 		
 * 		使用位运算模拟。
 * 		比如 5+17=22
 * 		对应的二进制位
 * 		5:101
 * 		17:10001.
 * 		
 * 		
 * @author REN
 * @date 2016年9月7日 下午10:34:30
 */
public class _47AddTwoNumbers {
	
	public static int Add(int num1,int num2) {
        
		int sum;
		int carry;
		do{
			sum = num1 ^ num2; //异或，同为0 或者 1 时候为0.否则为1.模拟加法
			carry = (num1 & num2) << 1; //位与运算，模拟相加产生的进位。同为1时候为1，其他时候为0.进位向左移动一位。
			
			num1 = sum;
			num2 = carry;
		}while(num2 != 0); //不产生进位则停止。
		
		return sum;
		
    }

	public static void main(String[] args) {
		int sum = Add(10,5);
		System.out.println(sum);
	}
}
