import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//majority occurence who occur n/3 times
public class Majority2 {
    

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
        }
        Set<Integer> keySet=map.keySet();
        for(Integer key:keySet){
            if(map.get(key)>nums.length/3)
            ans.add(key);
        }
        return ans;
    }
}
