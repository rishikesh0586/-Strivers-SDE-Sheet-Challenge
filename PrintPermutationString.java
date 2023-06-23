
import java.io.*; 
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
public class Solution {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        findAllPermutations(res, s.toCharArray(), new StringBuilder(), visited);
        return res;
    }

   static void findAllPermutations(List<String> res, char[] chars, StringBuilder curr, boolean[] visited) {
        if (curr.length() == chars.length) {
            res.add(curr.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i])
                continue;
            curr.append(chars[i]);
            visited[i] = true;
            findAllPermutations(res, chars, curr, visited);
            curr.deleteCharAt(curr.length() - 1);
            visited[i] = false;
        }
    }
}
