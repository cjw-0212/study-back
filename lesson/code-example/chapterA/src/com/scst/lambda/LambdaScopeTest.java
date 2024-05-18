package com.scst.lambda;

import java.util.function.Consumer;

public class LambdaScopeTest {
    public int x = 0;

    class FirstLevel {
        public int x = 1;

        void methodInFirstLevel(int x) {
            int z = 99; // z not x,y
            Consumer<Integer> myConsumer = (y) -> {
                System.out.println("x = " + x); // 23, x must be final or effectively final
                System.out.println("y = " + y); //23
                System.out.println("this.x = " + this.x); // 1
                System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x); // 0
            };
            myConsumer.accept(23);
            System.out.println("z = " + z); // 99
        }
    }

    public static void main(String... args) {
        LambdaScopeTest st = new LambdaScopeTest();
        FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
