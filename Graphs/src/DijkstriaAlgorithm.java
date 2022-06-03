import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DijkstriaAlgorithm {
    private static class Edge implements Comparable<Edge>{
        int source;
        int destination;
        int cost;
        Edge(int source, int destination, int cost){
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge obj) {
            return obj.cost-this.cost;
        }
        public String toString(){
            return " " + this.source +" "+ this.destination +" "+ this.cost;
        }
    }
//    Lazy Implementation
    static private int dijkstras(int source,int destination,ArrayList<Edge>[] adjList ){
        int[] costToAllNodes = new int[adjList.length];
        Arrays.fill(costToAllNodes, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Edge(0,0,0));
        costToAllNodes[0] = 0;
        boolean[] visited = new boolean[adjList.length];
        while(!pq.isEmpty()){
            Edge remove = pq.poll();
            visited[remove.source] = true;

            for(Edge node: adjList[remove.destination]){
                if(visited[node.destination]) continue;
                int newDist = costToAllNodes[node.source]+node.cost;
                if(newDist < costToAllNodes[node.destination]){
                    costToAllNodes[node.destination] = newDist;
                    pq.add(new Edge(node.source,node.destination,newDist));
                }

            }
            System.out.println(pq);
        }

        return costToAllNodes[destination];
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] adjList = new ArrayList[5];
        for(int i=0;i<5;i++){
            adjList[i] = new ArrayList<>();
        }
        adjList[0].add(new Edge(0,1,4));
        adjList[0].add(new Edge(0,2,1));
        adjList[1].add(new Edge(1,3,1));
        adjList[2].add(new Edge(2,1,2));
        adjList[2].add(new Edge(2,3,5));
        adjList[3].add(new Edge(3,4,3));
        System.out.println(Arrays.toString(adjList));
        System.out.println(dijkstras(0,4,adjList));

    }
}
