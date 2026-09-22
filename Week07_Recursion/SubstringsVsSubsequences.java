public class SubstringsVsSubsequences {
    // Prints all substrings: contiguous parts.
    public static void printSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    // Prints all subsequences: characters may be skipped.
    public static void printSubsequences(String s, int index, String current) {
        if (index == s.length()) {
            System.out.println(current);
            return;
        }

        printSubsequences(s, index + 1, current);

        printSubsequences(s, index + 1,
                current + s.charAt(index));
    }

    public static void main(String[] args) {
        System.out.println("Substrings:");
        printSubstrings("abc");

        System.out.println("\nSubsequences:");
        printSubsequences("abc", 0, "");
    }
}
