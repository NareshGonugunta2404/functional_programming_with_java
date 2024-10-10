import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NGFP07IntermediateStreamOperationAreLazy {

    public static void main(String[] args) {
       /* List<Course> courses = List.of(
                new Course("Spring", "Framework", 96, 200),
                new Course("SpringBoot", "Framework", 97, 250),
                new Course("API", "MicroServices", 94,   240),
                new Course("MicroServices", "MicroServices", 95, 250),
                    new Course("FulltStack", "FulltStack", 94, 260),
                new Course("AWS", "Cloud", 92, 210),
                new Course("Azure", "Cloud", 98, 220),
                new Course("Docker", "Cloud", 92, 230),
                new Course("Kubernetes", "Cloud", 96, 210)
        );*/

        List<String> courses = List.of("Spring", "Spring Boot", "API", "MicoServies", "AWS", "PCF", "Azure", "Docker", "k8s");


        courses.stream().filter(course -> course.length() > 10)
                        .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();

        System.out.println("---------------");
        courses.stream().peek(System.out::println).filter(course -> course.length() > 10)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();

    }

}
