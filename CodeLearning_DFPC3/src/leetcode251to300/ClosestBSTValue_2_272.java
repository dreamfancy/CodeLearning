package leetcode251to300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class ClosestBSTValue_2_272 
{
	
	//Sol 1: Two Stacks for two directions
	//Number above and below k should be considered separately
    public List<Integer> closestKValues(TreeNode root, double target, int k) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null || k<=0) return result;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        inorderTraverse(root,false,target,s1);
        inorderTraverse(root,true,target,s2);       
        
        while(k>0)
        {
            if(s1.isEmpty())
            {
                result.add(s2.pop());
            }
            else if(s2.isEmpty())
            {
                result.add(s1.pop());
            }
            else if(Math.abs(s1.peek()-target)<Math.abs(s2.peek()-target))
            {
                result.add(s1.pop());
            }
            else
            {
                result.add(s2.pop());
            }
            k--;
        }
        return result;
        
    }
    
    private void inorderTraverse(TreeNode root, boolean reverse, double target, Stack<Integer> stack)
    {
        if(root==null) return;
        inorderTraverse(reverse ? root.right : root.left,reverse,target,stack);
        if((reverse && root.val<=target) || (!reverse && root.val>target)) return;
        stack.push(root.val);
        inorderTraverse(reverse? root.left : root.right,reverse,target,stack);
    }	

    //Sol 2: Priority Queue (as the time complex already minimum o(n)
    public List<Integer> closestKValues_2(TreeNode root, final double target, int k) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null || k<=0) return result;
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(k, new Comparator<Integer>()
       {
           @Override
           public int compare(Integer i1, Integer i2)
           {
               return (Math.abs(i1-target) - Math.abs(i2-target))>0 ? 1 : -1;
           }
       });
       
        inorderTraverse(root,pqueue,target);
        for(int i=0; i<k; i++)
        {
            result.add(pqueue.poll());
        }
        return result;
    }
    private void inorderTraverse(TreeNode root, PriorityQueue<Integer> pqueue,double target)
    {
        if(root==null) return;
        inorderTraverse(root.left,pqueue,target);
        pqueue.offer(root.val);
        inorderTraverse(root.right,pqueue,target);

    }
}
