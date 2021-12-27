import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NullTest {
    public void test1() {
        List<String> list = new ArrayList<String>(Arrays.asList("aaa", "bbb", null, "ddd"));
        for (String str : list) {
            System.out.println("isNull = " + Objects.isNull(str));
            System.out.println("nonNull = " + Objects.nonNull(str));
            //System.out.println(Objects.requireNonNull(str, "Message"));
            System.out.println("toString = " + Objects.toString(str, "null"));
            System.out.println("requireNonNullElse = " + Objects.requireNonNullElse(str, "null"));
        }
    }

    // https://qiita.com/rubytomato@github/items/92ac7944c830e54aa03d
    public void test2() {
        List<String> list = new ArrayList<String>(Arrays.asList("aaa", null, "ccc", "", "eee"));
        for (String str : list) {
            System.out.println("====================================================");
            // ofNullable
            Optional<String> opt = Optional.ofNullable(str);
            // isPresent
            opt.ifPresent(f -> System.out.println("ifPresent       = " + f));
            // or
            System.out.println("or              = " + opt.or(() -> Optional.of("null")).get());
            // ifPresentOrElse
            opt.ifPresentOrElse((f) -> {
                    System.out.println("ifPresentOrElse = " + f);
                },
                () -> {
                    System.out.println("ifPresentOrElse = null");
                });
            // isPresent
            System.out.println("isPresent       = " + opt.isPresent());
            // isEmpty
            System.out.println("isEmpty         = " + opt.isEmpty());
            // orElse
            System.out.println("orElse          = " + opt.orElse("null"));
            // orElseGet
            System.out.println("orElseGet       = " + opt.orElseGet(() -> "null"));
            // orElseThrow
            try {
                System.out.println("orElseThrow     = " + opt.orElseThrow());
            } catch (Exception ex) {
                System.out.println("orElseThrow     = " + ex.getMessage());
            }
            // get
            try {
                System.out.println("get             = " + opt.get());
            } catch (Exception ex) {
                System.out.println("get             = throw exception");
            }
            // of
            try {
                Optional<String> opt2 = Optional.of(str);
                System.out.println("Optional.of     = " + opt2.get());
            } catch (Exception ex) {
                System.out.println("Optional.of     = throw exception");
            }
            // filter
            System.out.println("filter          = " + opt.filter(p -> p.equals("aaa")||p.equals("eee")).orElse("null"));
            // map
            System.out.println("map             = " + opt.map(p -> p.length()).orElse(0));
            // flatMap
            System.out.println("flatMap         = " + opt.flatMap(p -> Optional.of(p + "flatMap")).orElse("null"));
            // stream
            opt.stream().forEach(System.out::println);
        }
    }
}
