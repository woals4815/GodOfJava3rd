import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateSample {
    public static void main(String[] args) {
        PredicateSample sample = new PredicateSample();

        Predicate<String> predicateLength5= (String s) -> s.length() == 5;
        Predicate<String> predicateLength10= (String s) -> s.length() == 10;
        Predicate<String> predicateContains = (String s) -> s.contains("God");
        //Generic에는 비교할 매개변수의 타입
        Predicate<Integer> predicateStart = (Integer s) -> s.equals(1);
    }
    private void predicateTest(Predicate<String> p, String data) {
        System.out.println(p.test(data));
    }
    private void predicateAnd(Predicate<String> p1, Predicate<String> p2, String data) {
        System.out.println(p1.and(p2).test(data));
    }
    private void predicateOr(Predicate<String> p1, Predicate<String> p2, String data) {
        System.out.println(p1.or(p2).test(data));
    }
    private void predicateNegate(Predicate<String> p, String data) {
        System.out.println(p.negate().test(data));
    }

}
