package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Null can be a number of LinkedList<TreeNode> or ArrayList since the TreeNode allows null

public class SerializeBST_449 {

//	public class Codec {

// Encodes a tree to a single string.
	
	//Solution_1: BST: Scan line by line. If one child is null, then use #
	public static String serialize(TreeNode root) {
	 
		if(root == null) return null;
		Queue<TreeNode> qStore = new LinkedList<TreeNode>();
		StringBuilder sb = new StringBuilder();
		qStore.add(root);
		while(!qStore.isEmpty())
		{
			TreeNode cur = qStore.remove();  //Null value and empty are two things in the queue!
			if(cur != null)
			{
				sb.append(cur.val+",");
				qStore.add(cur.left);
				qStore.add(cur.right);
			}
			else
			{
				sb.append("#,");
			}
		}
		
		System.out.print(sb);
		System.out.println("&&&&&&&&&&&&&&&");
		return sb.toString();
    }

	public static String testData()
	{
		TreeNode root = new TreeNode(1);
		
		TreeNode line21 = new TreeNode(2);
		root.left = line21;
		TreeNode line22 = new TreeNode(3);
		root.right = line22;
		
		TreeNode line31 = new TreeNode(4);
		line21.left = line31;
		TreeNode line32 = new TreeNode(5);
		line21.right = line32;
		TreeNode line34 = new TreeNode(6);
		line22.right = line34;
		
		TreeNode line48 = new TreeNode(7);
		line34.right = line48;
		TreeNode line416 = new TreeNode(8);
		line48.right = line416;
		
		return serialize(root);
	}
	
	/*
	public static void main(String[] args)
	{
		deserialize(testData());
	}
	*/
	
	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
	 
		if (data == null) return null;
		
		String[] arrStore = data.split(",");
		/*
		for(int i = 0; i<arrStore.length; i++)
		{	
			System.out.println(arrStore[i]);
		}
		*/
		Queue<TreeNode> qtree = new LinkedList<TreeNode>();
		int c = 0;
		TreeNode root = new TreeNode(Integer.parseInt(arrStore[0]));
		qtree.add(root);
		c++;
		while(c<arrStore.length)
		{
			if(qtree.isEmpty()) continue;
			TreeNode curNode = qtree.remove();
			if(arrStore[c].equals('#'))
			{
				curNode.left = null;
			}
			else
			{
				int val = Integer.parseInt(arrStore[c]);
				TreeNode leftChild = new TreeNode(val);
				curNode.left = leftChild;
				qtree.add(leftChild);
			}
			c++;
			
			if(arrStore[c].equals("#"))
			{
				curNode.right = null;
			}
			else
			{
				int val = Integer.parseInt(arrStore[c]);
				TreeNode rightChild = new TreeNode(val);
				curNode.right = rightChild;
				qtree.add(rightChild);	
			}
			c++;
		}
		
		return root;
		
	}


	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	

//Solution_2: Depth First Search using recursion! Especially when there are some routines repeat

public static String serialize_2(TreeNode root) {
	
	StringBuilder sb = new StringBuilder();
	if(root == null) return "#,";
	else
	{
		sb.append(root.val+",");
		sb.append(serialize_2(root.left));
		sb.append(serialize_2(root.right));
		return sb.toString();
	}
}


	public static TreeNode deserialize_2(String str) {
	
		if(str == null || str == "") return null;
		else
		{ 
			String[] strArr = str.split(",");
			ArrayList<String> arrl = new ArrayList<String>();
			for(int i=0; i<strArr.length; i++)
			{
				arrl.add(strArr[i]);
			}
				
			return deserialize_2(arrl);
		}
	}
	
	public static TreeNode deserialize_2(ArrayList<String> arrl)
	{
		if(!arrl.get(0).equals("#"))
		{
			TreeNode root = new TreeNode(Integer.parseInt(arrl.remove(0)));
			if(!arrl.isEmpty())
			{
				root.left = deserialize_2(arrl);
				root.right = deserialize_2(arrl); 
			}	
			return root;
		}
		else
		{
			return null;
		}
			
	//	return root;
	}
	
//	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		String temp = serialize_2(root);
		System.out.println(temp);
		deserialize_2(temp);
		
		
	}


}