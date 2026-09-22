import java.util.*;

public class LC989_AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = num.length - 1;
        int carry = k;

        while (i >= 0 || carry > 0) {
            if (i >= 0) carry += num[i--];
            result.addFirst(carry % 10);
            carry /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
    }
}
