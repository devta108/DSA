import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Coprime {
    static class Pair{
        int value;
        ArrayList<Integer> childs;
        Pair(int value, ArrayList<Integer> childs){
            this.value = value;
            this.childs = childs;
        }
        public String toString(){
            return " has value "+ this.value + " contains childs "+ this.childs;
        }
    }
    public static int[] getCoprimes(int[] nums, int[][] edges) {
        HashMap<Integer, Pair> adjList = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            adjList.put(i,new Pair(nums[i], new ArrayList<>()));
        }
        for (int[] edge:edges){
            Pair pair = adjList.get(edge[0]);
            pair.childs.add(edge[1]);
            adjList.put(edge[0],pair);
        }
        System.out.println(adjList);
        return new int[]{nums.length};
    }

    public static void main(String[] args) {
        getCoprimes(new int[]{2,3,3,2}, new int[][]{{0,1},{1,2},{1,3}});
    }
}
