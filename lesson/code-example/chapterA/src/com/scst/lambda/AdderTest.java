package com.scst.lambda;

public class AdderTest {

    public static void main(String[] args) {
        Adder c = x -> {
            x++;
            return x;
        };
        System.out.println(c.selfAdd(23));
    }

}
