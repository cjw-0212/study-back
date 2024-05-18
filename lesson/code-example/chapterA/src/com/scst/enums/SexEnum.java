package com.scst.enums;
import java.util.Arrays;

public enum SexEnum{
    //枚举值
    MAN(1, "男"), WOMAN(2, "女");
    //属性
    private Integer value;
    private String desc;

    //构造函数
    SexEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    //方法
    public Integer getValue() {
        return this.value;
    }

    @Override
    //返回枚举值的字符串表示
    public String toString() {
        return this.desc;
    }

    public static void main(String[] args) {
        SexEnum s1 = SexEnum.MAN;
        //将字符串初始化为枚举对象
        SexEnum s2 = SexEnum.valueOf("MAN");
        SexEnum s3 = SexEnum.WOMAN;
        System.out.println(s1 == s2);    //true
        //返回枚举值所在的索引位置, 从0开始
        System.out.println(s1.ordinal()); // 0
        System.out.println(s3.ordinal()); // 1
        //比较两个枚举值的索引位置大小
        System.out.println(s1.compareTo(s3)); //-1: MAN<WOMAN
        //返回所有的枚举值
        SexEnum[] enums = SexEnum.values();
        //遍历所有的枚举值
        for(SexEnum e:enums){
            System.out.println(e);
        }
        Arrays.asList(enums).forEach(System.out::println);  //男、女
    }
}