package offer;

import java.util.ArrayList;
import java.util.List;
/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * @author REN
 * @date 2016年6月13日 上午11:13:42
 */
public class _04ReplaceBlank {
	/**
	 * 解法一
	 * @param str
	 * @return
	 */
	public String replaceSpace(StringBuffer str) {

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < str.toString().length(); i++) {
			char c = str.charAt(i);
			if (c == ' ')
				result.append("%20");
			else {
				result.append(c);
			}
		}
		return result.toString();
	}
	/**
	 * 解法二
	 * @param str
	 * @return
	 */
	public String replaceSpace1(StringBuffer str) {

		return str.toString().replace(" ", "%20");
	}

}
