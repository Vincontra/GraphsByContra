public class BellmanFordAlgo {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = (int) 1e8;
        }
        dist[src] = 0;
        for (int i = 1; i <= V - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // to check neg weight cycle we should do this one more time if it updated the dist array that means neg cycle
        for (int j = 0; j < edges.length; j++) { // Nth time
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                dist[v] = dist[u] + wt;
                int arr[] = new int[1];
                arr[0] = -1;
                return arr;
            }
        }
        return dist;
    }
}
