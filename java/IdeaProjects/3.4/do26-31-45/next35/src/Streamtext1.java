import java.util.Arrays;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streamtext1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
//        stream.forEach(System.out::println);
//        IntStream in=stream.mapToInt(new ToIntFunction<String>() {
//            @Override
//            public int applyAsInt(String value) {
//                return Integer.parseInt(value);
//            }
//        }
//        );
        IntStream in=stream.mapToInt(Integer::parseInt);
//        in.forEach(System.out::print);
        int[] arr=in.toArray();
        System.out.println(Arrays.toString(arr));
        LongStream in2=Stream.of("12","234","235").mapToLong(Long::parseLong);
        System.out.println(Arrays.toString(in2.toArray()));
    }
}
