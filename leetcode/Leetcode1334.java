class Solution {
    static int distance[];
    public int findTheCity(int totalCities, int[][] edges, int thresholdDistance) {
        List<int[]>[] graph = new ArrayList[totalCities];
        for (int i = 0; i < totalCities; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int edge[] : edges) {
            int sourceCity = edge[0], destinitionCity = edge[1], distance = edge[2];
            graph[sourceCity].add(new int[] { destinitionCity, distance });
            graph[destinitionCity].add(new int[] { sourceCity, distance });
        }

        int numOfNeighbours = Integer.MAX_VALUE, cityWithMaximumNeighbours = -1;
        for (int city = 0; city < totalCities; city++) {
            int countOfNeighbour = dijsktra(graph, totalCities, city, thresholdDistance);
            if (countOfNeighbour <= numOfNeighbours) {
                numOfNeighbours = countOfNeighbour;
                cityWithMaximumNeighbours = city;
            }
        }
        return cityWithMaximumNeighbours;
    }

    public int dijsktra(List<int[]>[] graph, int n, int sourceCity, int thresholdDistance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                return a[1] - b[1];
            }
        );
        pq.add(new int[] { sourceCity, 0 });
        int count = 0;
        distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[sourceCity] = 0;

        while (!pq.isEmpty()) {
            int visitingCity[] = pq.remove();
            int city = visitingCity[0];
            int distanceTraversed = visitingCity[1];

            if (distanceTraversed > distance[city]) continue;
            count++;
            for (int[] neighbour : graph[city]) {
                int neighbourName = neighbour[0], distanceOfNeighbour = neighbour[1];
                if (distance[city] + distanceOfNeighbour <= thresholdDistance 
                && distanceOfNeighbour + distanceTraversed < distance[neighbourName]) {
                    pq.add(new int[] { neighbourName, distanceOfNeighbour + distanceTraversed });
                    distance[neighbourName] = distanceOfNeighbour + distanceTraversed;
                }
            }
        }
        return count;
    }
}
