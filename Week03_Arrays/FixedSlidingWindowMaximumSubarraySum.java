public class FixedSlidingWindowMaximumSubarraySum {
    public static int maxSum(int[] arr, int k) {
        if (k <= 0 || k > arr.length) return -1;

        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];

        int answer = sum;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }
}
