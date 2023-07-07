//Write a program that takes a list of integers as input and performs the following operations using lambda expressions:
//
//        Filter out the even numbers from the list.
//        Square each remaining number.
//        Calculate the sum of all squared numbers.


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaChallenge {

    public int sumOfAllEvenSquaredNumbers(List<Integer> numbers) {
        int sum = 0;
        sum = numbers.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n*n)
                .reduce(0, (a,b) -> a+b);

        return sum;
    }

    // Write a program that takes a list of strings as input and returns a new list
    // containing only the strings that start with a given prefix.
    public List<String> stringsWithGivenPrefix(List<String> string, String prefix){
        return string.stream()
                .filter(s -> s.startsWith(prefix))
                .toList();
    }

    // Write a program that takes a list of integers as input
    // and returns the product of all the even numbers in the list.

    public int productOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x%2 == 0)
                .reduce(1, (a,b) -> (a*b));
    }



    // Challenge 1: Prime Number Check
    //Write a program that takes a list of integers as input and uses lambda expressions
    // to filter out the prime numbers from the list.
    // The program should then print the count of prime numbers found.

    Predicate<Integer> isPrime = n -> {
        if (n < 1) return false;
        for (int i = 2; i < n; i++){
            if(n/i == 0){
                return true;
            }
        }
        return false;
    };

    public List<Integer> countOfPrimeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(isPrime)
                .collect(Collectors.toList());
    }













    public int sumOfEvenNumberSquared(List<Integer> numbers) {
       int sum = 0;
       sum = numbers.stream()
               .filter(n -> n % 2 == 0)
               .map(n -> n * n)
               .reduce(0, (a, b) -> a + b);
       return sum;
    }

    // Write a program that takes a list of strings as input and returns a new list
    // containing only the strings that start with a given prefix.

    public List<String> filterStringsBasedOnPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .toList();
    }

    // Write a program that takes a list of integers as input
    // and returns the product of all the even numbers in the list.
    public int productOfPositiveInts(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(1, (a, b) -> a * b);
    }

    // Write a program that takes a list of strings as input
    // and returns a new list containing the strings in uppercase.
    public List<String> upperCaseStrings(List<String> strings) {
        return strings.stream()
                .map(s -> s.toUpperCase())
                .toList();
    }

    // Write a program that takes a list of integers as input and
    // returns a new list containing the squares of all the numbers.

    public List<Integer> squaresOfAllNumbers(List<Integer> numbers){
        return numbers.stream()
                .map(n -> n*n)
                .toList();
    }

    // Write a program that takes a list of strings as input and
    // returns a new list containing only the strings that have an even length.
    public List<String> filterEvenLengthStrings(List<String> strings){
        return strings.stream()
                .filter(s -> s.length() % 2 == 0)
                .toList();
    }

    //Write a program that takes a list of integers as input
    // and returns a new list containing only the positive numbers.
    public List<Integer> filterPositiveIntegers(List<Integer> numbers){
        return numbers.stream()
                .filter(n -> n > 0)
                .toList();
    }

    // Write a program that takes a list of strings as input
    // and returns a new list containing the lengths of the strings.
    public List<Integer> returnStringLengthList(List<String> strings) {
        return strings.stream()
                .map(n -> n.length())
                .toList();
    }

    // Write a program that takes a list of integers as input
    // and returns the sum of all the numbers.
    public int returnSumOfAllNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (a, b) -> a + b);
    }

    // Challenge 1: Prime Number Check
    //Write a program that takes a list of integers as input and uses lambda expressions
    // to filter out the prime numbers from the list.
    // The program should then print the count of prime numbers found.

    public int getPrimeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 1 && n%2 != 0)
                .toList().size();
    }


    public static void main(String[] args) {
          LambdaChallenge lc = new LambdaChallenge();
//        System.out.println(lc.sumOfEvenNumberSquared(List.of(1,2,3,4,5,6,7,8,9,10)));
//        System.out.println(lc.filterStringsBasedOnPrefix(List.of("Ram", "Ravi", "Priyanka", "Rahul", "Sachin"), "R"));
//          System.out.println(lc.productOfPositiveInts(List.of(1,2,3,4,5,6,7,8,9,10)));
//        System.out.println(lc.upperCaseStrings(List.of("virat", "rohit", "rahane", "dhoni", "Akshith")));
//        System.out.println(lc.squaresOfAllNumbers(List.of(1,2,3,4,5,6,7,8,9,10))) ;
//        System.out.println(lc.filterEvenLengthStrings(List.of("Ram", "Ravi", "Priyanka", "Rahul", "Sachin")));
//        System.out.println(lc.filterPositiveIntegers(List.of(2, -3, -6, -8, 1, 4, 7)));
//        System.out.println(lc.returnStringLengthList(List.of("Ram", "Ravi", "Priyanka", "Rahul", "Sachin")));
//        System.out.println(lc.returnSumOfAllNumbers(List.of(1,2,3,4,5,6,7,8,9,10)));
        System.out.println(lc.getPrimeNumbers(List.of(1,2,3,4,5,6,7,8,9,10)));
        System.out.println(lc.countOfPrimeNumbers(List.of(1,2,3,4,5,6,7,8,9)).size());
    }
}
