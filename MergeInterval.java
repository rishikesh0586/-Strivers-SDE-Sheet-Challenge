import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        int currl=intervals[0][0];
        int currr=intervals[0][1];
        int s[]={currl,currr};
        ans.add(s);
        for(int i=1;i<n;i++)
        {
            if(currr>=intervals[i][0])
            {
                int temp[]=new int[2];
                temp[0]=Math.min(intervals[i][0],currl);
                temp[1]=Math.max(currr,intervals[i][1]);
                ans.set(ans.size()-1,temp);
            }
            else
                ans.add(intervals[i]);
            currl=ans.get(ans.size()-1)[0];
            currr=ans.get(ans.size()-1)[1];
        }
        return ans.toArray(new int[ans.size()][2]);
    } 
    }
