package main.java.topinterviewquestions.mediumq2;

/**
 * Runtime: 3 ms, faster than 73.94% of Java online submissions for Add Two Numbers.
 * Memory Usage: 47.7 MB, less than 28.28% of Java online submissions for Add Two Numbers.
 */

/**
 * Question
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        //initialize a node to use its next node to return
        ListNode returnNode = new ListNode(0);
        //assign returnNode to currentNode , l1 & l2 as input node
        ListNode l1=list1, l2=list2, currentNode = returnNode;
        //initialize carry that will hold 0 or 1 depends on the sum
        int carry = 0;

        if(l1 != null || l2 != null){
            while(l1 != null || l2 != null){
                //currentVal is sum of l1.val + l2.val + carry
                int currentVal = (l1!=null?l1.val:0);
                currentVal += (l2!=null?l2.val:0);
                currentVal += carry;

                //assign new value to carry based on current sum
                if(currentVal>9) carry = 1;
                else carry = 0;

                //create next node with currentVal modulus 10 to get it 1st decimal place value
                currentNode.next = new ListNode(currentVal%10);
                //update current node to next node
                currentNode = currentNode.next;
                //update current input node to next input node
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;
            }
        }

        //in case of carry of last node is more than 0, create a next node with carry value
        if(carry>0) {
            currentNode.next = new ListNode(carry);
        }

        return returnNode.next;

    }
}
