package com.scst.generic;

public class PECS {

    public static void main(String[] args) {
        CS();
        PE();
    }

    public static void CS() {
        Pair<? super Apple> fruitPair = new Pair<Fruit>();
        fruitPair.setFirst(new Apple(5));       //Apple可转型到Apple超类Fruit
        fruitPair.setSecond(new GreenApple(5)); //GreenApple可转型到Apple超类Fruit
        //fruitPair.setSecond(new Object());         //Object无法转型到Apple超类Fruit，故编译报错
        Fruit fruit = (Fruit)fruitPair.getFirst();   //?具有不确定性，出来的对象类型只能是Object，故需强制转换
    }

    public static void PE() {
        Pair<? extends Fruit> fruitPair = new Pair<Apple>(new Apple(3), new GreenApple(4));
        Fruit first = fruitPair.getFirst();          //Apple可以转型到Fruit
        Fruit second = fruitPair.getSecond();        //GreenApple可以转型到Fruit
        //fruitPair.setFirst(new Apple(5));          //?具有不确定性，故编译错误
    }


    public static void unrestrict() {   //不限定类型变量取值
        Pair<?> fruitPair = new Pair<Apple>(new Apple(3), new GreenApple(4));
        Fruit first = (Fruit)fruitPair.getFirst();      //?具有不确定性，出来的对象类型只能是Object，故需强制转换
        Fruit second = (Fruit)fruitPair.getSecond();    //?具有不确定性，出来的对象类型只能是Object，故需强制转换
        //fruitPair.setFirst(new Apple(5));             //?具有不确定性，故编译错误
    }

}
