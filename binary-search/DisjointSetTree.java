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

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        // Example usage
        int setSize = 10;
        DisjointSet disjointSet = new DisjointSet(setSize);

// Create individual sets
        for (int i = 0; i < setSize; i++) {
            disjointSet.makeSet(i);
        }

// Perform union operations
        disjointSet.union(0, 1);
        disjointSet.union(2, 3);
        disjointSet.union(4, 5);
        disjointSet.union(6, 7);

// Check if elements are in the same set
        System.out.println(disjointSet.find(0) == disjointSet.find(1)); // Should print true
        System.out.println(disjointSet.find(2) == disjointSet.find(3)); // Should print true
        System.out.println(disjointSet.find(4) == disjointSet.find(5)); // Should print true
        System.out.println(disjointSet.find(6) == disjointSet.find(7)); // Should print true
        System.out.println(disjointSet.find(0) == disjointSet.find(2)); // Should print false

    }

}

