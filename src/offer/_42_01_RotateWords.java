package offer;
/**
 * 题目描述

	牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
	写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
	但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
	这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
	Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * @author REN
 */
public class _42_01_RotateWords {

	/*
	 * 牛客网通过测试的答案。
	 */
	public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i >0;i--){
            o.append(a[i-1]);
            if(i > 1){
                o.append(" ");
            }
        }
        return o.toString();
    }
	/*
	 * 这道题就是传统的对字符串的操作。我认为主要的难点在于对字符串的首尾存在空格情况的处理。
	 * 比如输入“ I am a student. ”
	 * 应该输出：" student. a am I "
	 * 牛客网的测试用例没有考虑这种情况。
	 */
	public String ReverseSentenceMine(String str) {
		
        if(str.length()==0 || str.trim().equals(""))
        	return str;
        
        String[] strs = str.split(" ");
        StringBuffer sb = new StringBuffer();
        if(str.endsWith(" ")){
        	sb.append(" ");
        }
        for (int i = strs.length-1 ;i >=0; i--) {
			sb.append(strs[i]);
			if(i != 0)
				sb.append(" ");
		}
        if(str.startsWith(" ")){
        	sb.append(" ");
        }
        return sb.toString();
    }
}
