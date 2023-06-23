import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> result = new ArrayList<>();
        wordBreakHelper(s, dictionary, "", result);
        return result;
    }

    private static void wordBreakHelper(String s, ArrayList<String> dictionary, String answer, ArrayList<String> result) {
        int n = s.length();

        // Check every prefix one by one
        for (int i = 1; i <= n; i++) {
            String prefix = s.substring(0, i);

            // If dictionary contains this prefix
            if (dictionary.contains(prefix)) {
                // If no more elements are left, add the answer to the result
                if (i == n) {
                    result.add(answer + prefix);
                    return;
                }

                // Recursively check for the remaining string
                wordBreakHelper(s.substring(i, n), dictionary, answer + prefix + " ", result);
            }
        }
    }

    public static void main(String[] args) {
        String input = "Ihavewatchedthenewspider-manmovieinthetheater";
        ArrayList<String> dictionary = new ArrayList<>(Arrays.asList("apple", "devices", "love", "I", "have", "the", "new", "spider-man", "movie", "watched", "in", "theater"));

        ArrayList<String> result = wordBreak(input, dictionary);

        System.out.println("Input: " + input);
        System.out.println("Output: ");
        for (String word : result) {
            System.out.println(word);
        }
    }
}
