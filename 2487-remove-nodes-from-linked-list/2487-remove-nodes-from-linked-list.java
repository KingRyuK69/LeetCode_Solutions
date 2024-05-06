 class Solution {   
    public ListNode removeNodes(ListNode head) {
        // Base case, reached end of the list
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive call
        ListNode nextNode = removeNodes(head.next);

        // If the next node has greater value than head, delete the head
        // Return next node, which removes the current head and makes next the new head
        if (head.val < nextNode.val) {
            return nextNode;
        }

        // Keep the head
        head.next = nextNode;
        return head;
    }
}