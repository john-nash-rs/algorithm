class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];

        // Initialize each element as a disjoint set with rank 0
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Create a new set with a single element
    public void makeSet(int x) {
        parent[x] = x;
        rank[x] = 0;
    }

    // Find the representative (root) of the set containing x
    public int find(int x) {
        if (x != parent[x]) {
            // Path compression: Set the parent of x to the representative
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union two sets represented by their representatives
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank: Attach the shorter tree to the root of the taller tree
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                // If ranks are equal, arbitrarily choose one as the new root and increment its rank
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }
}
