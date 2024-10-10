import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

public class NGFP02Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 4, 5, 12, 7, 9, 6);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "MicoServies", "AWS", "PCF", "Azure", "Docker", "k8s");

        int result = NGFP02Functional.addListFunctional(numbers);
        System.out.println(result);

        // Double the numbers
        System.out.println(squaredNumbers(numbers));
        System.out.println();

        //even numbers list
        List<Integer> evenNumbersList = numbers.stream().filter(num -> num % 2 == 0).toList();
        System.out.println();

        //distinct and sort numbers
        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

    private static int addListFunctional(List<Integer> numbers) {
        return  numbers.stream()
                //.reduce(0, NGFP02Functional::sum);
                //.reduce(0, Integer::sum);
                .reduce(0, (x, y) -> x + y);
    }

    public static Integer sum(Integer n1, Integer n2) {
        return n1+n2;
    }

    public static List<Integer> squaredNumbers(List<Integer> numbers){
        return numbers.stream()
                .map(num -> num*num)
                .collect(Collectors.toList());
    }


}
