import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add
        list.add(10);
        list.add(20);
        list.add(30);

        // Retrieve
        System.out.println("Element at index 1: " + list.get(1));

        // Update
        list.set(1, 25);

        // Remove by index
        list.remove(0);

        // Verify element
        System.out.println("Contains 30: " + list.contains(30));

        System.out.println("Final list: " + list);
    }
}
