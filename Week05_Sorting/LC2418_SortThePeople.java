import java.util.*;

public class LC2418_SortThePeople {
    public static String[] sortPeople(String[] names, int[] heights) {
        Integer[] index = new Integer[names.length];

        for (int i = 0; i < names.length; i++) index[i] = i;

        Arrays.sort(index, (a, b) -> Integer.compare(heights[b], heights[a]));

        String[] result = new String[names.length];
        for (int i = 0; i < index.length; i++) {
            result[i] = names[index[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortPeople(
                new String[]{"Mary", "John", "Emma"},
                new int[]{180, 165, 170})));
    }
}
