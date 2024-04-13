//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static long reversedBits(long x) {
        long result = 0;
        int bits = 32; // Assuming 32-bit integer, change this if needed

        for (int i = 0; i < bits; i++) {
            result <<= 1; // Left shift result to make space for next bit
            result |= (x & 1); // OR the extracted bit with result
            x >>= 1; // Right shift x to move to the next bit
        }

        return result;
    }
}
