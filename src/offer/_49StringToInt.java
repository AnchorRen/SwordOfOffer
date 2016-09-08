package offer;

/**
 * 题目：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 
 * @author REN
 * @date 2016年9月8日 上午9:39:57
 */
public class _49StringToInt {

	public static void main(String[] args) {
		System.out.println(StrToInt("234"));
		System.out.println(StrToInt("-132"));
		System.out.println(StrToInt("+234"));
		System.out.println(StrToInt("@234"));
		System.out.println(StrToInt(""));
		System.out.println(StrToInt("+"));
		System.out.println(StrToInt("-"));
		System.out.println(StrToInt("2+34"));
		System.out.println(StrToInt("-+234"));
		System.out.println(StrToInt("99999999999999999999999999999999999999999234"));
	}

	public static int StrToInt(String str) {

		if (str.equals("") || str.length() == 0)
			return 0;
		char[] a = str.toCharArray();
		int start = 0;
		boolean isPlus = true;
		if (a[0] == '-'){
			isPlus = false;
			start = 1;
		}
		if (a[0] == '+'){
			start = 1;
		}
		int sum = 0;
		for (int i = start; i < a.length; i++) {
			if (a[i] < 48 || a[i] > 57) //ASCII码表 0--48  9--47
				return 0;
			sum = sum * 10 + a[i] - 48;
		}
		return isPlus ? sum : sum * -1;
	}
}
