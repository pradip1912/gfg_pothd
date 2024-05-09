//Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            String ans = obj.divisorGame(n) ? "True" : "False";
            System.out.println(ans);
        }
    }
}
//Driver Code Ends

// User function Template for Java

class Solution {
    public static boolean divisorGame(int n) {
        // Alice starts the game, if the number is even, Alice wins.
        // If the number is odd, Alice has to subtract an odd divisor, resulting in an even number.
        // Bob then receives an even number and repeats the process. 
        // As long as Alice starts with an even number, she can always force Bob to receive an odd number, hence she can win.
        return n % 2 == 0;
    }
}

