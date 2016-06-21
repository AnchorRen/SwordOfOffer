package offer;

import java.util.ArrayList;
import java.util.Stack;

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
				list = printListFromTailToHead(pNode.next);
			}
			list.add(pNode.val);
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
