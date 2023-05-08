import java.util.stream.Stream;

public class LinearCongruentialGeneratorTest {
    public static void main(String[] args) {
        Stream<Long> randomStream = HomeWork11.linearCongruentialGenerator(12345L, 25214903917L, 11L, (long) Math.pow(2, 48));
        randomStream.limit(10).forEach(System.out::println);

    }
}
