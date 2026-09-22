import java.util.*;

public class LC17_LetterCombinations {
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int index, String digits,
                                  StringBuilder current,
                                  List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = MAP[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(index + 1, digits, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
