import java.util.*;

public class KahnsAlgorithm {
//    static Stack<Integer> topoOrder;
    static boolean[] visited;

    public static void main(String[] args) {
        ArrayList<Integer>[] adjList = new ArrayList[6];
        for(int i=0;i<adjList.length;i++){
            adjList[i] = new ArrayList<Integer>();
        }
        adjList[2].add(3);
        adjList[3].add(1);
        adjList[4].add(0);
        adjList[4].add(1);
        adjList[5].add(0);
        adjList[5].add(2);
        System.out.println(Arrays.toString(adjList));
//        topoOrder = new Stack<>();
        visited = new boolean[adjList.length];
        int[] indegree = new int[adjList.length];
        for(int i=0;i<adjList.length;i++){
            for (int num: adjList[i]){
                indegree[num]++;
            }
        }
        Queue<Integer> Q = new ArrayDeque<>();
        for(int i =0;i<indegree.length;i++){
            if(indegree[i] == 0) Q.add(i);
        }
        while (!Q.isEmpty()){
            int remove = Q.remove();
            System.out.println(remove);

            for (int num:adjList[remove]){
                indegree[num]--;
                if(indegree[num]==0) Q.add(num);
            }
        }
    }
}
