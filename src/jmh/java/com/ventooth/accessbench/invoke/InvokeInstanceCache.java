package com.ventooth.accessbench.invoke;

import com.ventooth.accessbench.TargetClass;
import lombok.val;
import lombok.var;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public final class InvokeInstanceCache {
    public static final MethodHandle INV_PUBLIC_FINAL_FIELD;
    public static final MethodHandle INV_PRIVATE_FINAL_FIELD;

    public static final MethodHandle INV_PUBLIC_FIELD;
    public static final MethodHandle INV_PRIVATE_FIELD;

    static {
        try {
            val lk = MethodHandles.lookup();

            var field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
            INV_PUBLIC_FINAL_FIELD = lk.unreflectGetter(field);
            field =  TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
            field.setAccessible(true);
            INV_PRIVATE_FINAL_FIELD = lk.unreflectGetter(field);

            field = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
            INV_PUBLIC_FIELD = lk.unreflectGetter(field);
            field = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
            field.setAccessible(true);
            INV_PRIVATE_FIELD = lk.unreflectGetter(field);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
