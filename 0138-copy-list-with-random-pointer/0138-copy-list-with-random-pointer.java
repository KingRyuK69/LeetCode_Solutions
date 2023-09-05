/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>oldToNew = new HashMap<>();
        if(head==null)
            return null;
        Node oldCurr = head;
        Node prevNew = null;
        while(oldCurr!=null){
            Node newCurr = new Node(oldCurr.val);
            if(prevNew!=null){
                prevNew.next = newCurr;
            }
            prevNew = newCurr;
            oldToNew.put(oldCurr,newCurr);
            oldCurr = oldCurr.next;
        }
        oldCurr = head;
        while(oldCurr!=null){
            oldToNew.get(oldCurr).random = oldToNew.getOrDefault(oldCurr.random,null);
            oldCurr = oldCurr.next;
        }

        return oldToNew.get(head);

        

        

    }
}