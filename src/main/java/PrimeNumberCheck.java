import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        Predicate<Integer> isPrime = number -> {
            if (number <= 1) {
                return false;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        };

        List<Integer> primes = numbers.stream()
                .filter(isPrime)
                .collect(Collectors.toList());

        System.out.println("Prime numbers are: " + primes);
        System.out.println("Count of prime numbers is: " + primes.size());
    }
}
