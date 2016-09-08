package offer;
/**
 * 
 * 题目描述

		请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
		例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
		但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
		
		
		字符串中非数字符号：
			+
			-
			e 
			E
			.
			有E或者e的 只能有一个，前后都必须为整数。
			有小数点的，前后为数字，
			- + 必须为数字最前面，只能有一个。
	
 * 
 * @author REN
 * @date 2016年9月8日 下午4:12:10
 */
public class _53IsStringNumber {

	
	public static void main(String[] args) {
		String num = "-3.34344e2";
		char[] c = num.toCharArray();
		boolean result = isNumeric2(c);
		System.out.println(result);
	}
	
	//正则表达式
	 public boolean isNumeric3(char[] str) {
	        String string = String.valueOf(str);
	        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
	    }
	//投机取巧
	 public static  boolean isNumeric2(char[] str) {
	        try {
	            double re = Double.parseDouble(new String(str));
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        return true;
	    }
	
	public static  boolean isNumeric(char[] str) {
        
		//首先判断是否含有e或者e。有的话把E之前和后面分为两部分。
		int indexOfe = -1;
		int countOfe = 0;
		for(int i = 0;i< str.length ;i++){
			if(str[i] == 'e' || str[i] == 'E'){
				indexOfe = i;
				countOfe ++;
			}
		}
		//e的数量大于1，则不是数字。
		if(countOfe > 1)
			return false;
		//有一个e，则e前后分为两个数字。分别判断前后是不是数字。
		if(countOfe == 1){
			StringBuilder sb1 = new StringBuilder();
			for(int i = 0;i < indexOfe; i++){
				sb1.append(str[i]);
			}
			StringBuilder sb2 = new StringBuilder();
			for(int i = indexOfe + 1; i < str.length; i++){
				sb2.append(str[i]);
			}
			String num1 = sb1.toString();
			String num2 = sb2.toString();
			
			try {
				Double.parseDouble(num1);
			} catch (NumberFormatException e) {
				return false;
			}
			
			try {
				Integer.parseInt(num2);
			} catch (NumberFormatException e) {
				return false;
			}
			
			return true;
		}
		if(countOfe == 0){
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < str.length; i++){
				sb.append(str[i]);
			}
			String num = sb.toString();
			try {
				Double.parseDouble(num);
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		}
		return false;
    }
	
}
