import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> sortedNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
                if (numbers.get(i) % 2 == 0) {
                    sortedNumbers.add(numbers.get(i));
                }
            }
        }
        sortedNumbers.sort(Comparator.naturalOrder());
        System.out.println(sortedNumbers);
    }
}