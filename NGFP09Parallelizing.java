import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class NGFP09Parallelizing {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "MicroServices", "AWS", "PCF", "Azure", "Docker", "k8s");

        //courses.replaceAll(String::toUpperCase);

        List<String> modifyableCourses = new ArrayList<>(courses);
        modifyableCourses.replaceAll(String::toUpperCase);
        System.out.println(modifyableCourses);

        modifyableCourses.removeIf(course -> course.length() < 6);
        System.out.println(modifyableCourses);


    }

}
