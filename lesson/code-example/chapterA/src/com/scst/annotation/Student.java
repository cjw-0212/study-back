package com.scst.annotation;

public class Student {
	@RepeatableAnnotation(a=1,b=2,c=3)
	@RepeatableAnnotation(a=1,b=2,c=4)
	public static void add(int x, int y, int z)
	{
		if(z != x+y)
		{
			throw new ArithmeticException("Wrong");
		}
	}
}
