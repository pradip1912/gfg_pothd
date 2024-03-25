//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     static void help(ArrayList<String> ans,int zero,int one, StringBuilder temp, int N){
        if(temp.length()==N){
            ans.add(temp.toString());
            return;
        }
        if(one>zero){
            temp.append('0');
            help(ans,zero+1,one,temp,N);
            temp.deleteCharAt(temp.length()-1);
        }
        temp.append('1');
        help(ans,zero,one+1,temp,N);
        temp.deleteCharAt(temp.length()-1);
    }
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append('1');
	    help(ans,0,1,temp,N);
	    Collections.sort(ans);
	    Collections.reverse(ans);
	    return ans;
    }
}
