import java.util.*;
public class Kthlargest {
    int k;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    
    Kthlargest(int k, int[] arr) {
        this.k = k;
        for(int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
            if(queue.size()>k)
                queue.poll();
        }
    }

    void add(int num) {
        queue.offer(num);
        if(queue.size()>k){
            queue.poll();
        }
    }

    int getKthLargest() {
        return queue.peek();
    }
}