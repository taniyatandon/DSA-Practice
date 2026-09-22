import java.util.*;

public class IndexNegationDuplicatesDisappeared {
    // Array contains numbers from 1 to n.
    // Negative marking identifies duplicates and missing values.
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int value : nums) {
            int index = Math.abs(value) - 1;

            if (nums[index] < 0) {
                duplicates.add(Math.abs(value));
            } else {
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();

        for (int value : nums) {
            int index = Math.abs(value) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) missing.add(i + 1);
        }

        return missing;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicates: " + findDuplicates(a.clone()));
        System.out.println("Missing: " + findDisappearedNumbers(a.clone()));
    }
}
