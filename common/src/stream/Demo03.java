package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author CJW
 * @since 2023/11/9
 */
public class Demo03 {
    public static void main(String[] args) {
        /**
         * stream流的中间方法返回一个新的stream，每个stream只能使用一次，强烈建议使用链式编程
         * sretem中的数据改变不会影响原集合中的数据
         *
         * filter过滤
         * limit获取前几个
         * skip跳过前几个
         * distinct去重
         * concat合并两个流，依赖hashCode和equals方法
         */
        List<String> list = new ArrayList<>();
        list.add("张无忌-21");
        list.add("周芷若-22");
        list.add("赵敏-23");
        list.add("张三丰-24");
        list.add("张强-25");
        list.add("谢广坤-26");
        list.add("张三-27");

        list.stream().filter(item -> item.startsWith("张")).forEach(System.out::println);
        System.out.println("==========================================================");
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("==========================================================");
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("==========================================================");
        list.forEach(System.out::println);
        System.out.println("==========================================================");
        /**
         * 第一个参数为原数据，第二个处理返回的参数
         */
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s.split("-")[1]);
            }
        }).forEach(System.out::println);
        System.out.println("==========================================================");
        list.stream().map(item -> Integer.valueOf(item.split("-")[1])).forEach(System.out::println);
    }
}
