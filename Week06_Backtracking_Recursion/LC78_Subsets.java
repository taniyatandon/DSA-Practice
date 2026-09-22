import java.util.*;

public class LC78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int index, int[] nums,
                                  List<Integer> current,
                                  List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Do not choose current element.
        backtrack(index + 1, nums, current, result);

        // Choose current element.
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
