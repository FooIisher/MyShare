package linkLine;

import java.util.Scanner;

/**
 * 
 * @author fish
 *
 */
public class LinkRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkNode head = null ;
		int num =sc.nextInt();
			LinkNode temp = null ;
			for(int i=0;i<num;i++){
				if(i==0){
					head = new LinkNode(sc.nextInt());
					temp = head;
				}else{
					temp.next= new LinkNode(sc.nextInt());
					temp=temp.next;
				}
				
			}
		sc.close();
		System.out.println(head.toString());
//		System.out.println("reverseLink: "+ reverseLink(head).toString());
//		System.out.println("getMiddleLink: "+ getMiddleLinkNode(head).toString());
//		LinkNode middle = getMiddleLinkNode(head);
//		LinkNode left = head;
//		LinkNode right = middle.next;
//		middle.next =null;
//		System.out.println("mergeDoubleLinks: "+ mergeDoubleLinks(left,right).toString());
		
//		System.out.println("mergeSortLink: "+ mergeSort(head).toString());
		System.out.println("insertSortLink: " + insertSort(head).toString());
	}

	/**
	 * 实现链表的插入排序
	 * @param head
	 * @return
	 */
	private static LinkNode insertSort(LinkNode head) {
		LinkNode result = null;
		if(head==null||head.next==null){
			result =head;
		}else{
			result = new LinkNode(head.val);
			head =head.next;
			while(head!=null){
				if(head.val<result.val){
					LinkNode temp = new LinkNode(head.val);
					temp.next =result;
					result =temp;
				}else{
					LinkNode temp = result;
					if(temp.next!=null){
						while(temp.next!=null && temp.next.val<head.val){
							temp =temp.next;
						}
						if(temp.next != null){
						LinkNode insert = new LinkNode(head.val);
						insert.next = temp.next;
						temp.next = insert;
						}else{
							temp.next = new  LinkNode(head.val);
						}
					}else{
						temp.next = new  LinkNode(head.val);
					}
				}
				
				head =head.next;
			}
		}

		return result;
	}

	/**
	 * 实现俩表的归并排序
	 * @param head
	 * @return
	 */
	private static LinkNode mergeSort(LinkNode head) {
		if(head==null||head.next==null){
			   return head;
		}
		LinkNode mid = getMiddleLinkNode(head);
		LinkNode right = mid.next;
		mid.next = null;
		LinkNode left = head;
		return mergeDoubleLinks(mergeSort(left),mergeSort(right));
	}

	/**
	 * 对于两个有序链表进行合并排序
	 * @param left
	 * @param right
	 * @return
	 */
	private static LinkNode mergeDoubleLinks(LinkNode left, LinkNode right) {
		LinkNode result = new LinkNode(0);
		LinkNode temp = result;
		
		if(left==null){
			result =right;
		}
		if(right==null){
			result =left;
		}
		
		while(left!=null&&right!=null){
			
			if(left.val<right.val){
				temp.next = new LinkNode(left.val);
				temp=temp.next;
				left = left.next;
			}else{
				temp.next = new LinkNode(right.val);
				temp=temp.next;
				right = right.next;
			}
			
			if(left==null){
				temp.next=right;
			}
			
			if(right==null){
				temp.next=left;
			}
			
		}
		return result.next;
	}

	/**
	 * 获取链表的中间节点
	 * @param head
	 * @return
	 */
	private static LinkNode getMiddleLinkNode(LinkNode head) {
		LinkNode slow = head;
		LinkNode fast = head;
		while(fast.next!=null&&fast!=null){
			if(fast.next.next!=null){
				fast=fast.next.next;
				slow=slow.next;
			}else{
				fast=fast.next;
			}
		}
		return slow;
	}

	/**
	 * 倒置一个链表
	 * @param head
	 * @return
	 */
	
	private static LinkNode reverseLink(LinkNode head) {
		LinkNode result = null ;
		if(head.next==null){
			result = head;
		}else{
			LinkNode temp = result ;
			while(head!=null){
				temp = result;
				result = new LinkNode(head.val);
				result.next = temp;
				head = head.next;
			}
		}
		return result;
	}

	

	
}
