import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NGFP06CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 96, 200),
                new Course("SpringBoot", "Framework", 97, 250),
                new Course("API", "MicroServices", 94,   240),
                new Course("MicroServices", "MicroServices", 95, 250),
                    new Course("FulltStack", "FulltStack", 94, 260),
                new Course("AWS", "Cloud", 92, 210),
                new Course("Azure", "Cloud", 98, 220),
                new Course("Docker", "Cloud", 92, 230),
                new Course("Kubernetes", "Cloud", 96, 210)
        );

        Predicate<Course> coursePredicateGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> coursePredicateGreaterThan95Predicate = course -> course.getReviewScore() > 95;

        System.out.println(courses.stream().allMatch(coursePredicateGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(coursePredicateGreaterThan95Predicate));
        System.out.println(courses.stream().anyMatch(coursePredicateGreaterThan90Predicate));

        //sorting courses with comparator
        Comparator<Course> comparatorByNoOfStudents = Comparator.comparingInt(Course::getNoOfStudents);
        Comparator<Course> comparatorByNoOfStudentsDicreasingOrder = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparatorByNoOfStudents).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(comparatorByNoOfStudentsDicreasingOrder).collect(Collectors.toList()));

        Comparator<Course> comparatorByNoOfStudentsAndReviews = Comparator.comparingInt(Course::getReviewScore)
                .thenComparing(Course::getNoOfStudents)
                .reversed();
        System.out.println(courses.stream().sorted(comparatorByNoOfStudentsAndReviews)
                .collect(Collectors.toList()));

        // skip,
        System.out.println(
                courses.stream()
                        .sorted(comparatorByNoOfStudents)
                        .limit(3)
                        .collect(Collectors.toList()));

        //limit
        System.out.println(
                courses.stream()
                        .sorted(comparatorByNoOfStudents)
                        .skip(3)
                        .collect(Collectors.toList()));




        // takeWhile,
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore()>=95)
                .toList());

        // dropWhile
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .toList());


        // top, max, min, findFirst, findAny
        System.out.println(courses.stream()
                .findFirst());
        //Optional[Spring:Framework:96:200]

        System.out.println(courses.stream()
                        .min(comparatorByNoOfStudents));
        //Optional[Spring:Framework:96:200]

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore()<91)
                .max(comparatorByNoOfStudents)
              );
        //Optional.empty

        System.out.println(courses.stream()
                        .filter(course -> course.getReviewScore()<91)
                .max(comparatorByNoOfStudents)
                .orElse(new Course("Kubernetes", "Cloud", 96, 210)));
        //Kubernetes:Cloud:96:210

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 95)
                .findFirst());
        //Optional[Spring:Framework:96:200]

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 95)
                .findFirst());
        ///Optional[Spring:Framework:96:200]

        System.out.println(courses.stream()
                .filter(coursePredicateGreaterThan95Predicate)
                .findFirst());
        //Optional[Spring:Framework:96:200]


        // sum, average, count
        System.out.println(courses.stream()
                .filter(coursePredicateGreaterThan95Predicate)
                        .mapToInt(course -> course.getNoOfStudents())
                .sum()); // 880

        System.out.println(courses.stream()
                .filter(coursePredicateGreaterThan95Predicate)
                .mapToInt(course -> course.getNoOfStudents())
                .average()); //OptionalDouble[220.0]

        System.out.println(courses.stream()
                .filter(coursePredicateGreaterThan95Predicate)
                .mapToInt(course -> course.getNoOfStudents())
                .count()); //4

        System.out.println(courses.stream()
                .filter(coursePredicateGreaterThan95Predicate)
                .mapToInt(course -> course.getNoOfStudents())
                .max()); //OptionalInt[250]

        System.out.println(courses.stream()
                .filter(coursePredicateGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .min()); //OptionalInt[250]

        //groupBy

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));
        //{MicroServices=[API:MicroServices:94:240, MicroServices:MicroServices:95:250],
        // FulltStack=[FulltStack:FulltStack:94:260],
        // Cloud=[AWS:Cloud:92:210, Azure:Cloud:98:220, Docker:Cloud:92:230, Kubernetes:Cloud:96:210],
        // Framework=[Spring:Framework:96:200, SpringBoot:Framework:97:250]}

        System.out.println(
                courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );// {MicroServices=2, FulltStack=1, Cloud=4, Framework=2}

        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                            Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );//{MicroServices=Optional[MicroServices:MicroServices:95:250],
        // FulltStack=Optional[FulltStack:FulltStack:94:260], Cloud=Optional[Azure:Cloud:98:220],
        // Framework=Optional[SpringBoot:Framework:97:250]}


        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList())))
        );//MicroServices=[API, MicroServices],
        // FulltStack=[FulltStack],
        // Cloud=[AWS, Azure, Docker, Kubernetes],
        // Framework=[Spring, SpringBoot]

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getReviewScore,
                                Collectors.mapping(Course::getName, Collectors.toList())))
        );//{96=[Spring, Kubernetes], 97=[SpringBoot],
        // 98=[Azure], 92=[AWS, Docker], 94=[API, FulltStack], 95=[MicroServices]}

    }



}

class Course{

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name +":"+category +":"+reviewScore+":"+noOfStudents;
    }


}
