package com.ventooth.accessbench.invoke;

import com.ventooth.accessbench.TargetClass;
import lombok.val;
import lombok.var;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public final class InvokeStaticCache {
    public static final MethodHandle INV_PUBLIC_FINAL_STATIC_FIELD;
    public static final MethodHandle INV_PRIVATE_FINAL_STATIC_FIELD;

    public static final MethodHandle INV_PUBLIC_STATIC_FIELD;
    public static final MethodHandle INV_PRIVATE_STATIC_FIELD;

    static {
        try {
            val lk = MethodHandles.lookup();

            var field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
            INV_PUBLIC_FINAL_STATIC_FIELD = lk.unreflectGetter(field);
            field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
            field.setAccessible(true);
            INV_PRIVATE_FINAL_STATIC_FIELD = lk.unreflectGetter(field);

            field = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
            INV_PUBLIC_STATIC_FIELD = lk.unreflectGetter(field);
            field = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
            field.setAccessible(true);
            INV_PRIVATE_STATIC_FIELD = lk.unreflectGetter(field);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
