package 双指针;

import domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 141. 环形链表
 */

public class HasCycle {

    //利用集合
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head!=null){
            if(list.contains(head.next)){
                return true;
            }else {
                list.add(head);
            }
            head = head.next;
        }
        return false;
    }
    //快慢指针
    public boolean hasCycle2(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }
        ListNode slower = head;
        ListNode faster = head.next;
        while (slower!=faster){
            if(faster == null || faster.next ==null){
                return false;
            }
            slower = slower.next;
            faster = faster.next.next;
        }
        return true;
    }
}
