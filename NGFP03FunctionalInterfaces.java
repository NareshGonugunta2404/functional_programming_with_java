import jdk.jshell.execution.LoaderDelegate;

import javax.naming.BinaryRefAddr;
import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class NGFP03FunctionalInterfaces {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 4, 5, 12, 7, 9, 6);

        System.out.println("#################### Streams with functional interfaces Predicate,Function,Consumer,Supplier started ####################");
        Consumer<Integer> sysConsumer = System.out::println;
        Consumer<Integer> sysConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        Function<Integer, Integer> getSquareIntegerFunction = x -> x * x;
        Function<Integer, Integer> getSquareIntegerFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Predicate<Integer> isEvenNumberPredicate = x -> x % 2 == 0;
        Predicate<Integer> isEvenNumberPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        numbers.stream()
                .filter(isEvenNumberPredicate)
                .map(getSquareIntegerFunction)
                .forEach(sysConsumer);

        // Supplier -  No input and return something
        Supplier<LocalDateTime> getLocalDateTime = LocalDateTime::now;
        LocalDateTime localDateTimeSupplier = getLocalDateTime.get();

        Supplier<Integer> randomNumberSuplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println("randomNumberSuplier is = " + randomNumberSuplier.get());

        Supplier<Integer> getNumberSupplier = new Supplier<>() {
            @Override
            public Integer get() {
                return 2;
            }
        };

        System.out.println("===================== Streams with functional interfaces Predicate,Function,Consumer,Supplier completed =====================\n");

        System.out.println("#################### Reduce with BinaryOperator started ####################");
        BinaryOperator<Integer> sum1 = Integer::sum;
        BinaryOperator<Integer> sum3 = (a, b) -> a + b;
        BinaryOperator<Integer> sum2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        Integer sum = numbers.stream().reduce(0, sum1);
        System.out.println("sum is::" + sum);
        System.out.println("===================== Reduce with BinaryOperator completed =====================\n");


        // UnaryOperator take one input return one input with same type
        UnaryOperator<Integer> unaryOperatorOne = new UnaryOperator<Integer>() {

            @Override
            public Integer apply(Integer number) {
                return 123 * number;
            }
        };

        UnaryOperator<Integer> unaryOperator = (x) -> 123 * x;

        System.out.println("unaryOperator of number = " + unaryOperator.apply(10));


        // BiPredicate
        BiPredicate<Integer, String> biPredicate = new BiPredicate<Integer, String>() {
            @Override
            public boolean test(Integer number, String s) {
                return number < 10 && s.length() > 5;
            }
        };

        BiPredicate<Integer, String> biPredicateOne = (num, str) -> {
            return num < 10 && str.length() > 5;
        };
        System.out.println("biPrediate = "+biPredicateOne.test(9, "naresh"));


        // BiFunction
        BiFunction<String, Integer, String> biFunction = new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) {
                return s+integer;
            }
        };
        BiFunction<String, Integer, String> biFunctionOne = (x, y) -> {
            return "biFunction = "+x+y;
        };
        System.out.println("biFunction = " + biFunction.apply("naresh", 1993));
        System.out.println("biFunction = " + biFunctionOne.apply("naresh", 1993));

        // BiConsumer
        BiConsumer<Integer, String> biConsumer = new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("biConsumer = "+integer+s);
            }
        };
        BiConsumer<Integer, String> biConsumer1 = (x, s) -> {
            System.out.println("BiConsumer1 = "+x+s);
        };
        biConsumer.accept(12,"abc"); // 12abc
        biConsumer.accept(92,"xyz"); // 92abc


        // IntBinaryOperator - When we need to use primitive type of stream we can use IntBinaryOperator, where autoboxing is not required
        IntBinaryOperator intBinaryOperator = (x, y) -> x+y;
        System.out.println("intBinaryOperator "+intBinaryOperator.applyAsInt(19,73));


        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        // IntUnaryOperator
    }

}

