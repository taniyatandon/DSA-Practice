import java.util.*;

public class LC401_BinaryWatch {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }
}
