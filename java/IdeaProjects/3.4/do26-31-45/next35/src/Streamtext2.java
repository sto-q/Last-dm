import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streamtext2 {
    public static void main(String[] args) {
        List<String> number = Arrays.asList("1", "2", "390", "4677", "545", "645", "9998", "956");
        Stream<String> stream = Stream.of("12", "23", "12", "2345", "438579", "367");
//        Optional<String> first = stream.findFirst();
//        System.out.println(first.get());
        Stream<String> s = number.stream();
//        Optional<String> first = s.max(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

//        Optional<String> first = s.max(String::compareTo);
//        System.out.println(first.get());
        System.out.println(s.count());
//        number.stream().map(new Function<String,Integer>(){
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s);
//            }
//        });
//        boolean a=number.stream().map(Integer::parseInt).allMatch(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer>0;
//            }
//        });
        boolean a=number.stream().map(Integer::parseInt).allMatch(x->x>1);
        System.out.println(a);
        boolean b=number.stream().map(Integer::parseInt).anyMatch(x->x>900);
        System.out.println(b);
        boolean c=number.stream().map(Integer::parseInt).noneMatch(x->x<0);
        System.out.println(c);
    }
}