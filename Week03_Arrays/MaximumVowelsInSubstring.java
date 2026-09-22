public class MaximumVowelsInSubstring {
    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static int maxVowels(String s, int k) {
        if (k <= 0 || k > s.length()) return 0;

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) count++;
        }

        int answer = count;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) count++;
            if (isVowel(s.charAt(i - k))) count--;
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3)); // 3
    }
}
