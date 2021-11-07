package me.gicheol.algorithm.list;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));

        list.print();

        list.reverseRecursive();
        System.out.println();

        list.print();
    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

    private void print() {
        LinkedNode nodeToPrint = head;

        while (nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    /*
        시간복잡도 : O(n)
        공간복잡도 : O(1)
     */
    private void reverse() {
        LinkedNode current = head;
        LinkedNode prev = null;
        LinkedNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }

    /*
        시간복잡도 : O(n)
        공간복잡도 : O(1)
     */
    private void reverseRecursive() {
        LinkedNode head = this.head;
        this.head = reverseRecursive(head);
        this.tail = head;
    }

    private LinkedNode reverseRecursive(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        LinkedNode newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}
