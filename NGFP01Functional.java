import java.util.List;

public class NGFP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 9, 56, 83, 87, 98, 34, 21, 56, 87);
        NGFP01Functional.printAllNumbersInListFunctional(numbers);
        //print odd numbers by using lamda
        NGFP01Functional.printOddNumber(numbers);

        //print all course individually
        List<String> courses = List.of("Spring", "Spring Boot", "API",
                                        "Microservices", "AWS","PCF",
                                        "Docker", "Kubernetes");
        courses.forEach(System.out::println);

        //print words containing spring
        System.out.println("========== print words containing spring ================");
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        System.out.println("========== course names has atleast 4 letters ==============");
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
        //Squares of even number
        System.out.println("========== Squares of even number ==============");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(x -> x*x)
                .forEach(System.out::println);
        // course and course length
        System.out.println("========== course and course length ==============");
        courses.stream()
                .map(course -> course + " "+course.length())
                .forEach(System.out::println);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers){

        numbers.forEach(NGFP01Functional::print);// method reference
        System.out.println("==============Print Numbers==============");
        numbers.forEach(System.out::println);// method reference
        System.out.println();
        System.out.println("=============Even Numbers===============");
        numbers.stream().filter(NGFP01Functional::isEven).forEach(System.out::println);
        System.out.println();
        System.out.println("=============Even Numbers with lamda===============");
        numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

    }


    private static void printOddNumber(List<Integer> nubers){
        nubers.stream().filter(num -> num % 2 != 0).forEach(System.out::println);
    }

    private static void print(Integer num) {
        System.out.print(num);
        System.out.print(" ");

    }

    private static boolean isEven(Integer num){
        return num % 2 == 0;
    }
}
