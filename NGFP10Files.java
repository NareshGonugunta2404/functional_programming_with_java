import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NGFP10Files {

    public static void main(String[] args) throws IOException {

        /*Files.lines(Paths.get("TestFile.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);*/

        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);

    }

}
