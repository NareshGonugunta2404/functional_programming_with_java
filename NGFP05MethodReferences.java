import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class NGFP05MethodReferences {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "MicoServies", "AWS", "PCF", "Azure", "Docker", "k8s");

        courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        // method reference custom and inbuild
        courses.stream()
                .map(String :: toUpperCase)
                .forEach(NGFP05MethodReferences::print);

        Supplier<String> supplier = () -> new String();
        Supplier<String> supplierOne = String::new;

    }

    private static void print(String s) {
        System.out.println(s);
    }
}

