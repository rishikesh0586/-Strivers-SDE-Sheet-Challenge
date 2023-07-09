import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> getAllValidSentences(String s, String[] dict) {
        List<String> validSentences = new ArrayList<>();
        backtrack(s, dict, 0, new StringBuilder(), validSentences);
        return validSentences;
    }

    private static void backtrack(String s, String[] dict, int start, StringBuilder sentence, List<String> validSentences) {
        if (start == s.length()) {
            validSentences.add(sentence.toString());
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String currentWord = s.substring(start, i + 1);
            if (isValidWord(currentWord, dict)) {
                int sentenceLength = sentence.length();

                if (sentenceLength != 0) {
                    sentence.append(" ");
                }
                sentence.append(currentWord);

                backtrack(s, dict, i + 1, sentence, validSentences);

                sentence.setLength(sentenceLength); // backtrack by removing the currentWord
            }
        }
    }

    private static boolean isValidWord(String word, String[] dict) {
        for (String validWord : dict) {
            if (validWord.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
