package com.ventooth.accessbench.reflect;

import com.ventooth.accessbench.TargetClass;

import java.lang.reflect.Field;

public final class ReflectStaticCache {
    public static final Field REF_PUBLIC_FINAL_STATIC_FIELD;
    public static final Field REF_PRIVATE_FINAL_STATIC_FIELD;

    public static final Field REF_PUBLIC_STATIC_FIELD;
    public static final Field REF_PRIVATE_STATIC_FIELD;

    static {
        try {
            REF_PUBLIC_FINAL_STATIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
            REF_PRIVATE_FINAL_STATIC_FIELD = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
            REF_PRIVATE_FINAL_STATIC_FIELD.setAccessible(true);

            REF_PUBLIC_STATIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
            REF_PRIVATE_STATIC_FIELD = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
            REF_PRIVATE_STATIC_FIELD.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
