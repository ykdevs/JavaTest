import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public void test1() {
        List<String> listA = new ArrayList<String>(Arrays.asList("s", "a", "m", "u", "r", "a", "i"));
        // forEach
        listA.stream().forEach(System.out::println);
        // map = [S, A, M, U, R, A, I]
        System.out.println("map       = " + listA.stream().map(String::toUpperCase).collect(Collectors.toList()));
        // allMatch = true
        System.out.println("allMatch  = " + listA.stream().allMatch(p -> p.length() == 1));
        // anyMatch = true
        System.out.println("anyMatch  = " + listA.stream().anyMatch(p -> p.equals("a")));
        // reduce = samrai
        System.out.println("reduce    = " + listA.stream().reduce((accum, value)->accum + value).get());
        // collect = [s, a, m, u, r, a, i]
        System.out.println("collect   = " + listA.stream().collect(Collectors.toList()));
        // filter = [a, a, i]
        System.out.println("filter    = " + listA.stream().filter(p -> p.compareTo("m") < 0).collect(Collectors.toList()));
        // findFirst = a リストの前から
        System.out.println("findFirst = " + listA.stream().filter(p -> p.compareTo("m") < 0).findFirst().get());
        // findAny = a  並列処理で見つかった順
        System.out.println("findAny   = " + listA.stream().filter(p -> p.compareTo("m") < 0).findAny().get());
        // count = 7
        System.out.println("count     = " + listA.stream().count());
        // distinct = [s, a, m, u, r, i]
        System.out.println("distinct  = " + listA.stream().distinct().collect(Collectors.toList()));
        // limit = [s, a, m]
        System.out.println("limit(3)  = " + listA.stream().limit(3).collect(Collectors.toList()));
        // sorted
        System.out.println("sorted    = " + listA.stream().sorted().collect(Collectors.toList()));
        // peek 戻りのない処理を組み込む
        System.out.println("peek      = " + listA.stream().peek(System.out::println).collect(Collectors.toList()));
        // skip = [u, r, a, i]
        System.out.println("skip(3)   = " + listA.stream().skip(3).collect(Collectors.toList()));
        // sequential
        System.out.println("sequential = " + listA.stream().sequential().collect(Collectors.toList()));
        // parallel
        System.out.println("parallel   = " + listA.stream().parallel().collect(Collectors.toList()));
        // onClose
        Stream<String> stream = listA.stream();
        stream.onClose(() -> System.out.println("close"));
        System.out.println("onClose    = " + stream.collect(Collectors.toList()));
        stream.close();

        List<Integer> listB = Arrays.asList(0, 1, 2, -1, 2);
        // dropWhile = [2, -1, 2] 先頭から条件を満たす範囲を除く
        System.out.println("dropWhile = " + listB.stream().dropWhile(x -> x <= 1).collect(Collectors.toList()));
        // takeWhilte = [0, 1]
        System.out.println("takeWhile = " + listB.stream().takeWhile(x -> x <= 1).collect(Collectors.toList()));
        // max = 2
        System.out.println("max       = " + listB.stream().max((x, y) -> x.compareTo(y)).get());
        // min = -1
        System.out.println("mix       = " + listB.stream().min(Integer::compareTo).get());

        System.out.println("sum       = " + listB.stream().mapToInt(Integer::intValue).sum());
        System.out.println("average   = " + listB.stream().mapToInt(Integer::intValue).average().orElse(0));
        System.out.println("max       = " + listB.stream().mapToInt(Integer::intValue).max().orElse(0));
        System.out.println("min       = " + listB.stream().mapToInt(Integer::intValue).min().orElse(0));

        // generate
        Stream<Double> streamC = Stream.generate(() -> Math.random());
        streamC.limit(3).forEach(System.out::println);

        // Iterate
        Stream<Integer> streamD = Stream.iterate(2, x -> x * 2);
        streamD.limit(8).forEach(System.out::println);
    }
}
