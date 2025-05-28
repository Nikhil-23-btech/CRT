public class CycleDetection {
    private int  vertices;
    private int[][] adjacencymatrix;
    public CycleDetection(int vertices){
        this.vertices=vertices;
        adjacencymatrix=new int[vertices][vertices];
    }
    public void addedge(int src,int dest){
        adjacencymatrix[src][dest]=1;
        adjacencymatrix[dest][src]=1;
    }
    public void printgraph(){
        System.out.println("The Adjacency matrix");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(adjacencymatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private boolean dfscycle(int vertex,boolean[] visited,int parent){
        visited[vertex]=true;
        for(int i=1;i<vertices;i++){
            if(adjacencymatrix[vertex][i]==1){
                if(!visited[i]){
                    if(dfscycle(i, visited, vertex)){
                        return true;
                    }
                }
                else if(i!=parent){
                    return true;
                }
            }   
        }
        return false;
    }
    private boolean hascycle(){
        boolean[] visited=new boolean[vertices];
        for(int v=0;v<vertices;v++){
            if(!visited[v]){
                if(dfscycle(v, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CycleDetection connec=new CycleDetection(5);
        connec.addedge(0, 1);
        connec.addedge(1, 2);
        connec.addedge(2, 0);
        connec.addedge(3, 4);
        connec.printgraph();
        if(connec.hascycle()){
            System.out.println("The graph contains a cycle");
        }
        else{
            System.out.println("The graph doesnt contain a cycle");
        }
    }
}
