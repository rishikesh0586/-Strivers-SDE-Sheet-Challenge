import java.util.*;

public class Sort0and1s {
    

    public void sortColors(int[] nums) {
         PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);  //add
        }
         for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.remove();  //poll
        } 
    }
}