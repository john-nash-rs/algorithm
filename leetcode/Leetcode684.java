class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        //1st index array. To make solution more intutive. As nodes are numbered 1 to n.
        // Parent array keeps track of parent
        int[] parent = new int[n + 1];
        
        // Initialize parent array. It's same as making n different set. 
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        int[] result = new int[2];
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int parentU = find(parent, u);
            int parentV = find(parent, v);
            
            // Check if the vertices have the same parent
            if (parentU == parentV) {
                // This edge will form a cycle, return it
                result[0] = u;
                result[1] = v;
            } else {
                // Union the sets of u and v
                parent[parentU] = parentV;
            }
        }
        
        return result;
    }
    
    // Find operation with path compression
    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}
