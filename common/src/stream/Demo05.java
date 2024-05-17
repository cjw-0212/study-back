package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CJW
 * @since 2023/11/9
 */
public class Demo05 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌-男-21");
        list.add("周芷若-女-22");
        list.add("赵敏-女-23");
        list.add("张三丰-男-24");
        list.add("张强-男-25");
        list.add("谢广坤-男-26");
        list.add("张三-男-27");

        List<String> collect = list.stream().filter(item -> "男".equals(item.split("-")[1])).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
