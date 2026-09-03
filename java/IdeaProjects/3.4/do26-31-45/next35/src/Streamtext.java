import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamtext {
    public static void main(String[] args) {
//        List<Integer> number= Arrays.asList(1,2,3,4,5,6);
//        Stream<Integer> stream = number.stream();
//       Stream<Integer> number2= Stream.of(6,7,8,9);
//       Stream<Integer> number3= Stream.concat(stream,number2);
//       Stream<Integer> number4= Stream.iterate(6,i->i+1).map(Integer::parseInt).anyMatch(number->number % 2==1);
        Stream<Integer> stream = Stream.of(1,34,56,67,78,89,65,34,4565,34,23,23);
        Stream<Integer> stream2 = Stream.of(12,23,34,45,56,67,78,89,90);
//        Stream<String> stream3 = stream.filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("A");
//            }
//        });
//        Stream<String> stream3=stream.filter(s ->s%2==1).distinct().skip(1).limit(3).map(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) {
//                return integer+"ddd";
//            }
//        });
        Stream<String> stream3=stream.filter(s ->s%2==1).distinct().skip(1).limit(3).map(integer -> integer+" ");
//        stream3.forEach(System.out::println);
        List<String> list = stream3.collect(Collectors.toList());
        System.out.println(list);
//        Set<String> set=stream3.collect(Collectors.toSet());
        Set<String> set =list.stream().collect(Collectors.toSet());
        System.out.println(set);
    }
}
