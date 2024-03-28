//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        
        // Initialize the distance matrix with maximum values
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
            distance[i][i] = 0;
        }
        
        // Update the distance matrix with edge weights
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distance[from][to] = weight;
            distance[to][from] = weight;
        }
        
        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        
        int minCities = Integer.MAX_VALUE;
        int city = -1;
        
        // Iterate through all cities to find the one with the smallest number of reachable cities
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= minCities) {
                minCities = reachableCities;
                city = i;
            }
        }
        
        return city;
    }
}
