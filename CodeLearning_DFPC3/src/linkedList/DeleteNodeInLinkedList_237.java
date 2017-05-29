package linkedList;

public class DeleteNodeInLinkedList_237 
{
	//Attention that "Node in LinkedList is not always considered the same.
	//We can change the value of different nodes to realize "move the node"
	//(Actually it is moving values)
	
    public void deleteNode(ListNode node) 
    {
    	 if(node==null) return;  
         node.val = node.next.val;  
         node.next = node.next.next;  
         //Why we can summarize as above, because it does not need to 
         //consider the tail as mentioned in the question.
    }
	
}
