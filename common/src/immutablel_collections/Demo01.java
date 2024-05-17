package immutablel_collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author CJW
 * @since 2023/11/8
 */
public class Demo01 {
    public static void main(String[] args) {
        List<String> list = List.of("张三", "李四", "王五");
        list.forEach(System.out::println);
        System.out.println("----------------------------------");
        Set<Integer> integers = Set.of(1, 2, 3, 4, 5);
        integers.forEach(System.out::println);
        System.out.println("----------------------------------");
        /**
         * map的key不能重复
         * map的of方法最多只能放10个键值对，如果对于10个应该使用ofEntries方法
         */
        Map<Integer, Integer> map = Map.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6);
        map.forEach((k, v) -> System.out.println("k:" + k + " v:" + v));
        System.out.println("----------------------------------");
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(0, 0);
        map1.put(1, 1);
        map1.put(2, 2);
        map1.put(3, 3);
        map1.put(4, 4);
        map1.put(5, 5);
        map1.put(6, 6);
        map1.put(7, 7);
        map1.put(8, 8);
        map1.put(9, 9);
        map1.put(10, 10);
        map1.put(11, 11);
        map1.put(12, 12);
        Map map2 = Map.copyOf(map1);
        map2.forEach((k, v) -> {
            System.out.println("k:" + k + " v:" + v);
        });
    }
}
