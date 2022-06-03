import java.util.Collections;
import java.util.PriorityQueue;

public class LeetcodeDaily {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones) heap.add(stone);

        while(heap.size()>1){
            int h1 = heap.remove();
            int h2 = heap.remove();
            int diff = Math.abs(h1-h2);
            if(diff == 0) continue;
            else heap.add(diff);
            
        }
        return heap.peek();
    }

}
