package offer;
/**
 * 题目描述

		输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * 思路：
 * 		反转操作其实就是对指针的操作，如果直接操作指针，会导致链表断裂，不能继续遍历后续结点。
 * 		为了防止这种情况，需要定义两个结点临时存储前置结点和后置结点。
 * 
 * @author REN
 * @date 2016年6月21日 下午4:38:40
 */
public class _16ReverseList {

	public ListNode ReverseList(ListNode head) {

		ListNode pReverseHead = null; //反转后的头结点
		ListNode pNode = head; //当前结点
		ListNode pPre = null; //前置结点
		
		while(pNode != null){
			ListNode pNext = pNode.next; //后置结点
			
			if(pNext == null) //找到尾结点，也就是反转后的头结点。
				pReverseHead = pNode;
			
			pNode.next = pPre; //指针变换
			pPre = pNode; //结点后移
			pNode = pNext; //结点后移
		}
		return pReverseHead;
    }
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
