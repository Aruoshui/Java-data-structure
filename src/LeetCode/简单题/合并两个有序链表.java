package LeetCode.简单题;

public class 合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        class Solution {
            public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

                if(list1==null)return list2;
                if(list2==null)return list1;

                ListNode res = new ListNode();
                if(list1.val>list2.val){
                     res = list1;
                }else {
                     res = list2;
                }
                res.next = mergeTwoLists(res.next,list1.val>=list2.val?list1:list2);
                return res;

            }

        }
    }
}