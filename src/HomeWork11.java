import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HomeWork11 {
    public static String oddIndices(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }
    public static List<String> sortedName(List<String> names) {
        Stream<String> sortedStream = names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder());
        return sortedStream.collect(Collectors.toList());
    }
    public static String sortedNumbers(String[] numbers) {
        Stream<String> stream = Arrays.stream(numbers);
        Stream<Integer> numbersStream = stream.flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .map(Integer::valueOf);
        String str = numbersStream.sorted().
                map(String::valueOf)
                .collect(Collectors.joining(","));
        return str;
    }
    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> itr1 = first.iterator();
        Iterator<T> itr2 = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        while (itr1.hasNext() && itr2.hasNext()) {
            builder.accept(itr1.next());
            builder.accept(itr2.next());
        }
        return builder.build();
    }
}