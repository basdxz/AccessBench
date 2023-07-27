package com.ventooth.accessbench;

import lombok.val;

import java.lang.invoke.MethodHandles;

public class MethodHandleExample {
    public static void main(String[] args) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
        field.setAccessible(true);

        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact();
        System.out.println(value);
    }
}
