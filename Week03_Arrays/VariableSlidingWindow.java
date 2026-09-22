// Representative variable-size sliding-window problem:
// Find the minimum length subarray whose sum is at least target.
// This approach assumes all array values are positive.
public class VariableSlidingWindow {
    public static int minSubArrayLen(int target, int[] arr) {
        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= arr[left++];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
    }
}
