package linklist;


/**
 * @auther yujinlin
 * @date 2018/2/23.
 * 输入一个链表 使得基数节点降序，偶数节点升序
 */
public class LinkListRank {


    public static ListNode rank(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int i = 1;
        ListNode base = null;
        ListNode even = null;
        while (head != null) {
            if (i % 2 == 1) {
                if (base == null) {
                    base = new ListNode(head.val);
                } else {
                    ListNode temp = base;
                    if (head.val > base.val) {
                        ListNode in = new ListNode(head.val);
                        in.next = temp;
                        base = in;
                    } else {
                        while (temp.next != null && head.val < temp.next.val) {
                            temp = temp.next;
                        }
                        ListNode in = new ListNode(head.val);
                        in.next = temp.next;
                        temp.next = in;
                    }
                }
            } else {
                if (even == null) {
                    even = new ListNode(head.val);
                } else {
                    ListNode temp = even;
                    if (head.val < even.val) {
                        ListNode in = new ListNode(head.val);
                        in.next = temp;
                        even = in;
                    } else {
                        while (temp.next != null && head.val > temp.next.val) {
                            temp = temp.next;
                        }
                        ListNode in = new ListNode(head.val);
                        in.next = temp.next;
                        temp.next = in;
                    }

                }
            }
            i++;
            head = head.next;
        }
        ListNode temp = base;
        while (even != null) {
            ListNode in = new ListNode(even.val);
            in.next = temp.next;
            temp.next = in;
            temp = temp.next.next;
            even = even.next;
        }
        return base;
    }


}
