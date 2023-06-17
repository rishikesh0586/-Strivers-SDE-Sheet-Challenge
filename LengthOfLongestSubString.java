import java.util.*;
public class LengthOfLongestSubString {
    

    public int lengthOfLongestSubstring(String s) {
        
     if( s.length() ==0 ) return 0;
        int maxLength = Integer.MIN_VALUE;

        Map< Character , Integer> m = new HashMap<>();
        
        int st=0;
        int end = 0;

        while( end < s.length()){
            char c = s.charAt(end);
            if( m.containsKey(c) ){
                if( m.get(c) >= st)st = m.get(c)+1;                
                m.put(c , end);               
            }else{
                m.put( c, end);               
            }
            maxLength = Math.max( end-st+1, maxLength);
            end++;    

        }


        return  maxLength;

    }
}
