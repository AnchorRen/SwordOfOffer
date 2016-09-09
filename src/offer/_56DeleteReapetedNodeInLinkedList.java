package offer;
/**
 * 删除链表中重复的结点
 * 
 * 题目描述

		在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
		重复的结点不保留，返回链表头指针。 
		例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
		
 * @author REN
 * @date 2016年9月8日 下午8:08:31
 */
public class _56DeleteReapetedNodeInLinkedList {

	
	public static void main(String[] args) {
//		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(3);
//		ListNode node5 = new ListNode(4);
//		ListNode node6 = new ListNode(4);
//		ListNode node7 = new ListNode(5);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		node7.next = null;
		
		ListNode node1 = new ListNode(1);
		node1.next = null;
		ListNode node = new ListNode(-1);
		node.next = node1;
		while(node.next!=null){
			System.out.print(node.next.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("-------------------------------");
		ListNode result = deleteDuplication(node1);
		while(result!=null){
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	public static ListNode deleteDuplication(ListNode pHead)
    {
		//设置一个trick,作为新建的一个头结点
		ListNode first = new ListNode(-1);
		ListNode p = pHead;
		ListNode last = first;
		
		//初始判断
		if(pHead == null || pHead.next == null)
			return pHead;
		
		while(p!= null && p.next != null){
			if(p.val == p.next.val){ //值相同
				int val = p.val;
				while(p != null && p.val == val)
					p = p.next;
				last.next = p;
			}else{
				last.next = p;
				last = last.next;
				p = p.next;
			}
		}
		return first.next;
    }
	
	 public static class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
		}
}
