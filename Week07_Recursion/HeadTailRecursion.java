public class HeadTailRecursion {
    // Head recursion: recursive call happens before processing.
    public static void headRecursion(int n) {
        if (n == 0) return;
        headRecursion(n - 1);
        System.out.print(n + " ");
    }

    // Tail recursion: processing happens before recursive call.
    public static void tailRecursion(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        tailRecursion(n - 1);
    }

    public static void main(String[] args) {
        System.out.print("Head recursion: ");
        headRecursion(5);

        System.out.print("\nTail recursion: ");
        tailRecursion(5);
    }
}
