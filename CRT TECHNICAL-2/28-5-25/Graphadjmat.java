import java.util.*;
class Graphadjmat{
    private int vertices;
    private int[][] adjacencymatrix;
    public Graphadjmat(int vertices){
        this.vertices=vertices;
        adjacencymatrix=new int[vertices][vertices];
    }
    public void addedge(int src,int dest){
        adjacencymatrix[src][dest]=1;
        adjacencymatrix[dest][src]=1;
    }
    public void printgraph(){
        System.out.println("Adjacency matrix");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(adjacencymatrix[i][j]);
            }
            System.out.println();
        }
    }
    public void bfs(int start){
        boolean[] visited=new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();
        visited[start]=true;
        queue.offer(start);
        System.out.println("BFS traversal starting from vertex: "+start+":");
        while(!queue.isEmpty()){
            int vertex=queue.poll();
            System.out.print(vertex + " ");
            for(int i=0;i<vertices;i++){
                if(adjacencymatrix[vertex][i]==1&&!visited[i]){
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }
    public void dfsutil(int vertex,boolean[] visited){
        visited[vertex]=true;
        System.out.print(vertex+" ");
        for(int i=0;i<vertices;i++){
            if(adjacencymatrix[vertex][i]==1 && !visited[i]){
                dfsutil(i, visited);
            }
        }
    }
    public void dfs(int start){
        boolean[] visited=new boolean[vertices];
        System.out.println("DFS Traversal starting from vertex "+ start +" ");
        dfsutil(start, visited);
        System.out.println();
    }
    public static void main(String[] args) {
        Graphadjmat graph=new Graphadjmat(5);
        graph.addedge(0, 1);
        graph.addedge(0, 4);
        graph.addedge(1, 2);
        graph.addedge(1, 3);
        graph.addedge(1, 4);
        graph.addedge(2, 3);
        graph.addedge(3, 4);
        graph.printgraph();
        graph.bfs(0);
        graph.dfs(0);

    }
}