//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head); 
            t--;
        }
    } 
} 
   

// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
class Solution {
    Node deleteMid(Node head) {
        if (head == null || head.next == null) {
            // If the list has one or zero nodes, return null (empty list)
            return null;
        }
        
        Node slow = head;
        Node fast = head;
        Node prev = null; // To keep track of the node before slow
        
        // Fast pointer moves two steps, slow pointer moves one step
        while (fast != null && fast.next != null) {
            prev = slow; // Keep track of the node before the middle
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }
        
        // Disconnect the middle node
        if (prev != null && slow != null) {
            prev.next = slow.next; // Point the previous node's `next` to skip the middle node
        }
        
        return head; // Return the modified list without the middle node
    }
}
