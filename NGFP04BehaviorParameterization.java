import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NGFP04BehaviorParameterization {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 4, 5, 12, 7, 9, 6);

        System.out.println("#################### Behavior parameterization started to find odd and even numbers ####################");

        //Predicate<Integer> oddPredicate = x -> x%2!=0;
        filterAndPrintCommonPredicate(numbers, x -> x%2!=0);


        //Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        filterAndPrintCommonPredicate(numbers, x -> x % 2 == 0);

        //Predicate<Integer> predicate = x -> x % 3 == 0;
        filterAndPrintCommonPredicate(numbers, x -> x % 3 == 0);
        System.out.println("===================== Behavior parameterization completed =====================\n");

        System.out.println("#################### Behavior parameterization started to find square and cube of numbers ####################");

        //Function<Integer, Integer> squareFunction = x -> x*x;
        System.out.println(mapAndCreateNewList(numbers, x -> x*x));

        System.out.println();
        //Function<Integer, Integer> cubeFunction = x -> x*x*x;
        System.out.println(mapAndCreateNewList(numbers, x -> x*x*x));

        System.out.println("===================== Behavior parameterization completed for square & cube =====================\n");
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream().map(function).collect(Collectors.toList());
    }

    private static void filterAndPrintCommonPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }


}

