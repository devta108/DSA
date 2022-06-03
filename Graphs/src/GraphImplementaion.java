import java.io.*;
import java.util.*;

public class GraphImplementaion {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

        public Edge(int v2, int v1) {
            this.src = v1;
            this.nbr = v2;
        }
    }

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if(src == dest){
            if(wsf> lpathwt){
                lpath = psf;
                lpathwt = wsf;
            }
            else if(wsf<spathwt){
                spath = psf;
                spathwt = wsf;
            }
            else if(wsf>cpathwt && wsf<criteria){
                cpath = psf;
                cpathwt = wsf;
            }
            else if(wsf<fpathwt && wsf>criteria){
                cpath = psf;
                cpathwt = wsf;
            }
            System.out.println(psf +" @"+ wsf);
            pq.add(new Pair(wsf,psf));
            return;
        }
        System.out.println(psf +" @"+ wsf);
        visited[src] = true;
        for(Edge edge: graph[src]){
            if(!visited[edge.nbr]){
                multisolver(graph, edge.nbr,dest,visited,criteria,k,psf+edge.nbr,wsf+edge.wt);
            }
        }
        visited[src] = false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        System.out.println(noOfInfected(graph,t,src,visited));
    }
    static int noOfInfected(ArrayList<Edge>[] graph,int time, int src, boolean[] visited){
        int result = 1;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(src);
        visited[src] = true;
        time--;
        while(time!=0&&!Q.isEmpty()){
            int remove = Q.remove();
            System.out.println(time+","+ result);
            for(Edge e: graph[remove]){
                if(visited[e.nbr]) continue;

                else{
                    Q.add(e.nbr);
                    visited[e.nbr]= true;
                    result++;
                }
            }
            time--;
        }
        return result;
    }
    static int isCyclic(ArrayList<Edge>[] graph,int src,boolean[] visited){
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(src);
        int cycleLength = 0;
        while(!Q.isEmpty()){
            int remove = Q.remove();
            if(visited[remove]){
                if(cycleLength%2==0&&cycleLength>2)
                    return 0;
                else{
                    cycleLength = 0;
                    continue;
                }
            }
            visited[remove] = true;
            cycleLength++;
            for(Edge e : graph[remove]){
                if(!visited[e.nbr])
                    Q.add(e.nbr);
            }
        }
        return 1;
    }
    static boolean isOddCyclePresent(ArrayList<Edge>[] graph,int src,boolean[] visited){
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(src);
        int cycleLength = 0;
        while(!Q.isEmpty()){
            int remove = Q.remove();
            if(visited[remove]){
                if(cycleLength%2==1) {
                    System.out.println(cycleLength);
                    return true;}
                else{
                    cycleLength = 0;
                    continue;
                }
            }
            cycleLength++;
            visited[remove] = true;
            for(Edge e : graph[remove]){
                if(!visited[e.nbr])
                    Q.add(e.nbr);
            }
        }
        return false;
    }
}