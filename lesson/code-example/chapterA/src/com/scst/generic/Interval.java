package com.scst.generic;

import java.io.Serializable;

//泛型类
public class Interval<T> implements Serializable {

    private T lower, upper;

    public Interval(T lower, T upper) {
        this.lower = lower;
        this.upper = upper;
    }

    //泛型方法
    public static <U> U getMiddle(U... a) {
        return a[a.length / 2];
    }

    public T getLower() {
        return lower;
    }

    public void setLower(T lower) {
        this.lower = lower;
    }

    public T getUpper() {
        return upper;
    }

    public void setUpper(T upper) {
        this.upper = upper;
    }
}
