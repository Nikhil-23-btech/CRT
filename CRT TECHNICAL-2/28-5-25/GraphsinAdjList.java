import java.util.*;
public class GraphsinAdjList {
    private int vertices;
    private List<List<Integer>> adjacencylist;
    public GraphsinAdjList(int vertices) {
        this.vertices = vertices;
        adjacencylist = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencylist.add(new ArrayList<>());
        }
    }
    public void addedge(int src, int dest) {
        adjacencylist.get(src).add(dest);
        adjacencylist.get(dest).add(src);
    }
    public void printlist() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer neighbour : adjacencylist.get(i)) {
                System.out.print(" -> " + neighbour);
            }
            System.out.println();
        }
    }
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        System.out.println("BFS traversal starting from vertex: " + start + ":");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (Integer neighbour : adjacencylist.get(vertex)) {  
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println();
    }
    public void dfsutil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (Integer neighbour : adjacencylist.get(vertex)) { 
            if (!visited[neighbour]) {
                dfsutil(neighbour, visited);
            }
        }
    }
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS Traversal starting from vertex " + start);
        dfsutil(start, visited);
        System.out.println();
    }
    public static void main(String[] args) {
        GraphsinAdjList graph = new GraphsinAdjList(5);
        graph.addedge(0, 1);
        graph.addedge(0, 2);
        graph.addedge(1, 3);
        graph.addedge(2, 4);
        graph.printlist();
        graph.bfs(0);
        graph.dfs(0);
    }
}
