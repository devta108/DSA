import java.util.*;

public class TopologicalSort {
    static Stack<Integer> topoOrder;
    static boolean[] visited;

    static void dfs(ArrayList<Integer>[] nums, int currNode){
        visited[currNode] = true;
        System.out.println(Arrays.toString(visited));
        for (int i = 0; i < nums[currNode].size(); i++) {
            if(!visited[nums[currNode].get(i)]){
                dfs(nums,nums[currNode].get(i));
            }
        }
        topoOrder.push(currNode);
    }
    public static void main(String[] args) {
        ArrayList<Integer>[] nums = new ArrayList[6];
        for(int i=0;i<nums.length;i++){
            nums[i] = new ArrayList<Integer>();
        }
        nums[2].add(3);
        nums[3].add(1);
        nums[4].add(0);
        nums[4].add(1);
        nums[5].add(0);
        nums[5].add(2);
        System.out.println(Arrays.toString(nums));
        topoOrder = new Stack<>();
        visited = new boolean[nums.length];
        for(int i =0;i<nums.length;i++){
            if(!visited[i]){
                dfs(nums,i);
            }
        }
        System.out.println(topoOrder);
        //    Kahn's Algorithm
        int[] inDegree = new int[nums.length];

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i].size() == 0) q.add(i);
            else inDegree[i] = nums[i].size();
        }

        while(!q.isEmpty()){
            int rem = q.remove();

        }
    }


}
