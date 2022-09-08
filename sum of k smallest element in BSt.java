//  Given a Binary Search Tree. Find sum of all elements smaller than and equal to Kth smallest element.

// Example 1:

// Input: 
//           20
//         /    \
//        8     22
//      /    \
//     4     12
//          /    \
//         10    14   , K=3

// Output: 22
// Explanation:
// Sum of 3 smallest elements are: 
// 4 + 8 + 10 = 22

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            int n=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    System.out.println(g.sum(root,n));
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    Node(int key){
        this.data = key;
        this.left = this.right = null;
    }
}
*/

class Tree {
    int sum(Node root, int k) { 
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return 0;
        inOrder(root,arr);
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum +=arr.get(i);
        }
        return sum;
    }
    ArrayList<Integer> inOrder(Node root, ArrayList<Integer> arr){
        if(root == null)return arr;
        if(root.left!=null){
            inOrder(root.left,arr);
        }
        arr.add(root.data);
        if(root.right!=null){
            inOrder(root.right,arr);
        }
        return arr;
    }
}
