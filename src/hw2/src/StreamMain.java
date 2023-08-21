import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;

public class StreamMain {
    public static void main(String[] args) {
        Stream.of(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4)
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(naturalOrder())
                .forEach(x -> System.out.print(x + " "));
    }
}