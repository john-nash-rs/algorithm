class Solution {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return dfs(graph, source, destination, new HashSet<>());
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int current, int destination, Set<Integer> visited) {
        if (current == destination) {
            return true;
        }

        visited.add(current);

        List<Integer> neighbors = graph.getOrDefault(current, Collections.emptyList());
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor) && dfs(graph, neighbor, destination, visited)) {
                return true;
            }
        }

        return false;
    }
}
