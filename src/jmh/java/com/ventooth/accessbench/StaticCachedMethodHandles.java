package com.ventooth.accessbench;

import lombok.val;
import lombok.var;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public final class StaticCachedMethodHandles {
    public static final MethodHandle PUBLIC_FINAL_STATIC_FIELD;
    public static final MethodHandle PRIVATE_FINAL_STATIC_FIELD;

    public static final MethodHandle PUBLIC_STATIC_FIELD;
    public static final MethodHandle PRIVATE_STATIC_FIELD;

    static {
        try {
            val lk = MethodHandles.lookup();

            var field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
            PUBLIC_FINAL_STATIC_FIELD = lk.unreflectGetter(field);
            field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
            field.setAccessible(true);
            PRIVATE_FINAL_STATIC_FIELD = lk.unreflectGetter(field);

            field = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
            PUBLIC_STATIC_FIELD = lk.unreflectGetter(field);
            field = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
            field.setAccessible(true);
            PRIVATE_STATIC_FIELD = lk.unreflectGetter(field);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
