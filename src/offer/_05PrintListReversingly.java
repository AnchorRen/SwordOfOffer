package offer;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 从尾到头打印链表.
 * 	
 * 题目描述
	输入一个链表，从尾到头打印链表每个节点的值。 
     输入描述:
	输入为链表的表头
    输出描述:
	输出为需要打印的“新链表”的表头
	
	
 * @author REN
 * @date 2016年9月11日 上午9:59:12
 */
public class _05PrintListReversingly {

	/**
	 * 解法一
	 * 
	 * 使用递归方式实现。递归的本质是堆栈结构
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		ListNode pNode = listNode;
		
		if(pNode != null){
			if(pNode.next != null){
				list = printListFromTailToHead(pNode.next); //先递归添加子结点的值
			}
			list.add(pNode.val); //再添加本节点的值。
		}
		return  list;
    }

	/**
	 * 解法二
	 * 
	 * 借助栈结构
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		
		Stack<Integer> stack = new Stack<>();
		while(listNode != null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		
		ArrayList<Integer> list  = new ArrayList<>();
		//注意这一步需要用这个判断。不能用for循环，因为stack每次pop()操作后stack的长度都会变化。
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		return list;
		
	}
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}
