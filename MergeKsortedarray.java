import java.util.*;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(ArrayList<Integer> kArray : kArrays){
            for(Integer x : kArray){
                queue.offer(x);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
	}
}