import java.util.*;
public class Connectedcomponents {
    private int vertices;
    private int[][] adjacencymatrix;
    public Connectedcomponents(int vertices){
        this.vertices=vertices;
        adjacencymatrix=new int[vertices][vertices];
    }
    public void addedge(int src,int dest){
        adjacencymatrix[src][dest]=1;
        adjacencymatrix[dest][src]=1;
    }
    public void printgraph(){
        System.out.println("The adjacency matrix:");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(adjacencymatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void bfs(int start,boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        visited[start]=true;
        queue.offer(start);
        System.out.println("the BFS traversal starting from vertex "+ start +" ");
        while(!queue.isEmpty()){
            int vertex=queue.poll();
            System.out.print(vertex + " ");
            for(int i=0;i<vertices;i++){
                if(adjacencymatrix[vertex][i]==1 && !visited[i]){
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }
    public void findConnectedComponents(){
        boolean[] visited=new boolean[vertices];
        System.out.println("The connected components:");
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                System.out.print("Component");
                bfs(i,visited);
            }
        }
    }
    public static void main(String[] args) {
        Connectedcomponents conn=new Connectedcomponents(7);
        conn.addedge(0, 1);
        conn.addedge(0, 2);
        conn.addedge(1, 2);
        conn.addedge(3, 4);
        conn.addedge(5, 6);
        conn.printgraph();
        conn.findConnectedComponents();
    }
}
