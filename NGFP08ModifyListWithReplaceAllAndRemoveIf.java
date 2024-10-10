import java.util.stream.LongStream;

public class NGFP08ModifyListWithReplaceAllAndRemoveIf {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        //System.out.println(LongStream.range(0, 1000000000).sum());
        // Parallel functional code use multiple cores to execute the stream.
        // First it will split the function and finally combine the result
        System.out.println(LongStream.range(0, 1000000000).parallel().sum());
        System.out.println(System.currentTimeMillis() - time);

    }

}
