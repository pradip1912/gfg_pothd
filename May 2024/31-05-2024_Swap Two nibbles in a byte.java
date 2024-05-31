//Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}//Driver Code Ends

// User function Template for Java

class Solution {
    static int swapNibbles(int n) {
        // Mask for low nibble is 0x0F (00001111)
        // Mask for high nibble is 0xF0 (11110000)
        
        // Extract the low nibble and shift it left by 4 bits
        int lowNibble = (n & 0x0F) << 4;
        
        // Extract the high nibble and shift it right by 4 bits
        int highNibble = (n & 0xF0) >> 4;
        
        // Combine the shifted nibbles
        return lowNibble | highNibble;
    }
}
