package com.ventooth.accessbench;

import lombok.val;
import lombok.var;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public final class InstanceCachedMethodHandles {
    public static final MethodHandle PUBLIC_FINAL_FIELD;
    public static final MethodHandle PRIVATE_FINAL_FIELD;

    public static final MethodHandle PUBLIC_FIELD;
    public static final MethodHandle PRIVATE_FIELD;

    static {
        try {
            val lk = MethodHandles.lookup();

            var field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
            PUBLIC_FINAL_FIELD = lk.unreflectGetter(field);
            field =  TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
            field.setAccessible(true);
            PRIVATE_FINAL_FIELD = lk.unreflectGetter(field);

            field = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
            PUBLIC_FIELD  = lk.unreflectGetter(field);
            field = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
            field.setAccessible(true);
            PRIVATE_FIELD = lk.unreflectGetter(field);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
