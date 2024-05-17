package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author CJW
 * @since 2023/11/9
 */
public class Demo04 {
    public static void main(String[] args) {
        /**
         * 终结方法
         * foreach遍历
         * count返回个数
         * toArray首局数据放到数组
         */
        List<String> list = new ArrayList<>();
        list.add("张无忌-21");
        list.add("周芷若-22");
        list.add("赵敏-23");
        list.add("张三丰-24");
        list.add("张强-25");
        list.add("谢广坤-26");
        list.add("张三-27");

        System.out.println(list.stream().filter(name -> name.startsWith("张")).count());

        String[] strings1 = list.stream().filter(name -> name.startsWith("张")).toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int i) {
                return new String[i];
            }
        });
        for (String s : strings1) {
            System.out.println(s);
        }

        String[] strings = list.stream().filter(name -> name.startsWith("张")).toArray(length -> new String[length]);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
