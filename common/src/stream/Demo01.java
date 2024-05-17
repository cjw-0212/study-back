package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2023/11/9
 */
public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三丰");
        list.add("张强");
        //张开头长度为三
        list.stream().filter(name -> name.startsWith("张") && name.length() == 3).forEach(System.out::println);
    }
}
