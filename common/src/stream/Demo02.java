package stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author CJW
 * @since 2023/11/9
 */
public class Demo02 {
    public static void main(String[] args) {
        //单列集合获得流水线
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "a", "a", "a", "a");
        list.stream().forEach(System.out::println);
        System.out.println("==========================================================");
        //双列集合获得流水线
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.keySet().stream().forEach(System.out::println);
        map.entrySet().stream().forEach(System.out::println);
        System.out.println("==========================================================");
        //数组获得流水线
        int[] arr = {1, 2, 3, 4, 5, 6};
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("==========================================================");
        /**
         * Stream.of()是可变长参数，也可以放入数组，但是必须是引用数据类型的，基本数据类型数组的整体会被当成一个参数放入
         */
        Stream.of(arr).forEach(System.out::println);
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Stream.of(arr1).forEach(System.out::println);
        System.out.println("==========================================================");
        //零散数据获得流水线
        Stream.of(10, 11, 12, 13, 14, 15).forEach(System.out::println);
    }
}
