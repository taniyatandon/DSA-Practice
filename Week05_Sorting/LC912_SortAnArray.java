import java.util.*;

public class LC912_SortAnArray {
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;

        int m = l + (r - l) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }

        while (i <= m) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];

        for (int x = 0; x < temp.length; x++) a[l + x] = temp[x];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(
                new int[]{5, 2, 3, 1})));
    }
}
