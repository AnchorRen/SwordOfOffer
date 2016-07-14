package offer;
/**
 * 题目描述

		输入两个链表，找出它们的第一个公共结点。
	
	思路：
		首相想到的最粗鲁的方法为：先遍历一个链表，每次遍历一个结点就从另一个结点中遍历寻找相同的结点。如果两个链表的长度
	分别为m、n 那么复杂度为 O（mn）。显然这个方法不是想要的。
		由于单向链表每个节点只有一个指针指向下一个节点。所以只要两个链表有公共结点，那么公共节点之后的所有节点就都相等。
	所以，只要两个链表有公共结点。那么，它们的尾巴就是相同的。所以，要是能够从尾巴开始一个一个向前遍历，直到找到第一个
	不相同的结点后面就是第一个相同的了。可是从后遍历不借助外部空间不能做到啊！
		可以反过来思考，先计算出两个链表各自的长度，计算长度差值。然后对长度较长的数组遍历差值个数，则剩下两个数组长度想通啦！
	之后两个数组一起遍历，只要找到第一个相同的结点，就是我们想要的结点啦！ 这个方法的时间复杂度为 O(m+n). 
 * @author REN
 * @date 2016年7月14日 下午8:14:22
 */
public class _37FirstCommonNodeInLists {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		
		if(pHead1 == null || pHead2 == null)
			return null;
		int length1 = 0;
		int length2 = 0;
		ListNode node1 = pHead1;
		ListNode node2=  pHead2;
		while(node1 != null){
			length1++;
			node1 = node1.next;
		}
		while(node2 != null){
			length2++;
			node2 = node2.next;
		}
		int div = length1 - length2;
		if(div > 0){
			for(int i = 0;i<div;i++){
				pHead1 = pHead1.next;
			}
		}else{
			for(int i = 0;i<-div;i++){
				pHead2 = pHead2.next;
			}
		}
		
		for(int i = 0;i<(length1<length2?length1:length2);i++){
			if(pHead1 == pHead2)
				return pHead1;
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return null;
    }
	
	public class ListNode {
		int val;
		ListNode next = null;
		
	    ListNode(int val) {
			this.val = val;
		}
	}
}
