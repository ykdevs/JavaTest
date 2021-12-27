import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.sejuku.net/blog/15487
 */
public class ListStreamTest {

    /**
     * ２つのリストをマージする
     */
    public void test1 () {
        List<String> listA = new ArrayList<String>(Arrays.asList("s", "a", "m", "u", "r", "a", "i"));
        List<String> listB = new ArrayList<String>(Arrays.asList("e", "n", "g", "i", "n", "e", "e", "r"));
        List<String> listC = new ArrayList<String>();

        System.out.println("before");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);

        for(String a : listA){
            for(String b : listB){
                if(a.equals(b)){
                    listC.add(a);
                    break;
                }
            }
        }

        System.out.println("after");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);
    }

    public void test2() {
        List<String> listA = new ArrayList<String>(Arrays.asList("s", "a", "m", "u", "r", "a", "i"));
        List<String> listB = new ArrayList<String>(Arrays.asList("e", "n", "g", "i", "n", "e", "e", "r"));
        List<String> listC = new ArrayList<String>();

        System.out.println("before");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);

        for(String a : listA){
            if(listB.contains(a)){
                listC.add(a);
            }
        }

        System.out.println("after");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);
    }

    public void test3() {
        List<String> listA = new ArrayList<String>(Arrays.asList("s", "a", "m", "u", "r", "a", "i"));
        List<String> listB = new ArrayList<String>(Arrays.asList("e", "n", "g", "i", "n", "e", "e", "r"));
        List<String> listC = new ArrayList<String>();

        System.out.println("before");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);

        ListUtils.intersection(listA, listB).stream().forEach(i -> listC.add(i));

        System.out.println("after");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);

    }

    public void test4() {
        List<String> listA = new ArrayList<String>(Arrays.asList("s", "a", "m", "u", "r", "a", "i"));
        List<String> listB = new ArrayList<String>(Arrays.asList("e", "n", "g", "i", "n", "e", "e", "r"));
        List<String> listC = new ArrayList<String>();

        System.out.println("before");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);

        for(String a : listA){
            if(listB.contains(a)){
                listC.add(a);
            }
        }

        System.out.println("after");
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListC = " + listC);
    }

    public void test5() {
        final List<String> numTextList = Arrays.asList("0", "1", null);

        final List<Integer> numList = numTextList.stream()
                .filter((String numText) -> {
                    return Objects.nonNull(numText);
                })
                .map((String numText) -> {
                    return Integer.parseInt(numText);
                })
                .collect(Collectors.toList());

        System.out.println("numTextList = " + numTextList);
        System.out.println("numList = " + numList);
    }
}
