class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // Save the next node
            ListNode temp = curr.next;

            // Reverse the link
            curr.next = prev;

            // Move prev forward
            prev = curr;

            // Move curr forward
            curr = temp;
        }

        return prev;
    }
}