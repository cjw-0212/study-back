package com.scst.generic;

public class IntervalCalculator implements Calculator<Interval<Integer>> {

    public Interval<Integer> add(Interval<Integer> operand1, Interval<Integer> operand2) {
        int lower = operand1.getLower() + operand2.getLower();
        int upper = operand1.getUpper() + operand2.getUpper();
        return new Interval<>(lower, upper);
    }

    public static void main(String[] args) {
        Calculator<Interval<Integer>> c = new IntervalCalculator();
        Interval<Integer> i1 = new Interval<>(1, 2);
        Interval<Integer> i2 = new Interval<>(3, 4);
        Interval<Integer> i3 = c.add(i1, i2);
        Integer low = i3.getLower();
        Integer upper = i3.getUpper();
        System.out.println("[" + low + "," + upper + "]");
        System.out.println(Interval.<String>getMiddle("L", "M", null));
    }
}
