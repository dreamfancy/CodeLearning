package basic;

public class ListNode<T> {
    T val;
    ListNode next;
    ListNode pre;  //If it is single linkedlist, please comment out this line
    ListNode(T x) { val = x; }
    
    ListNode()
    {
    }
}
