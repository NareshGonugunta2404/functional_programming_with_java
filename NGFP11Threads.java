import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NGFP11Threads {

    public static void main(String[] args) throws IOException {

        // Traditional way of Runnable thread implementation
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i< 50; i++){
                    System.out.println(Thread.currentThread().getId()+" : "+Thread.currentThread().getName()+" : "+i);
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.start();
        Thread t3 = new Thread(runnable);
        t3.start();


        System.out.println("Functional programming Runnable implementation");
        Runnable runnable1FP =  () -> {
            IntStream.range(0, 50)
                    .forEach( i -> System.out.println("Functional programming"+Thread.currentThread().getId()+" : "+Thread.currentThread().getName()+" : "+i));
        };

        Thread th1 = new Thread(runnable1FP);
        th1.start();
        Thread th2 = new Thread(runnable1FP);
        th2.start();
        Thread th3 = new Thread(runnable1FP);
        th3.start();



    }

}
