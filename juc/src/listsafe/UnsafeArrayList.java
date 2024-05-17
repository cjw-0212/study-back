package listsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author CJW
 * @since 2024/3/8
 */
public class UnsafeArrayList {
    public static void main(String[] args) {
        //会产生ConcurrentModificationException并发修改异常,add方法没有synchronized
        //List<String> list = new ArrayList<>();

        //Vector的add方法上有synchronized，不会出现并发修改异常
        //List<String> list=new Vector<>();

        //获取支持并发的集合
        //List<String> list= Collections.synchronizedList(new ArrayList<>());

        //推荐 写时复制技术 并发读独立写 每次写时复制一份写完之后再合并
        //List<String> list=new CopyOnWriteArrayList<>();

        //HashSet的不安全
        //Set<String> set=new HashSet<>();
        //Set<String> set=new CopyOnWriteArraySet<>();

        //Map<String,String> map=new HashMap<>();
        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                //添加
                //list.add(UUID.randomUUID().toString());
                map.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
                //获取
                System.out.println(map);
            }).start();
        }
    }
}
