package com.scst.generic;

import java.io.Serializable;

//泛型接口
public interface Calculator<T extends Serializable> {
    public T add(T operand1, T operand2);
}


