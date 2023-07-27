package com.ventooth.accessbench.reflect;

import com.ventooth.accessbench.TargetClass;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;


public final class ReflectInstanceCache {
    public static final ReflectInstanceCache REFLECT_INSTANCE_CACHE = new ReflectInstanceCache();

    public final Field REF_PUBLIC_FINAL_STATIC_FIELD;
    public final Field REF_PRIVATE_FINAL_STATIC_FIELD;

    public final Field REF_PUBLIC_STATIC_FIELD;
    public final Field REF_PRIVATE_STATIC_FIELD;

    public final Field REF_PUBLIC_FINAL_FIELD;
    public final Field REF_PRIVATE_FINAL_FIELD;

    public final Field REF_PUBLIC_FIELD;
    public final Field REF_PRIVATE_FIELD;

    private ReflectInstanceCache() {
        try {
            REF_PUBLIC_FINAL_STATIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
            REF_PRIVATE_FINAL_STATIC_FIELD = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
            REF_PRIVATE_FINAL_STATIC_FIELD.setAccessible(true);

            REF_PUBLIC_STATIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
            REF_PRIVATE_STATIC_FIELD = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
            REF_PRIVATE_STATIC_FIELD.setAccessible(true);

            REF_PUBLIC_FINAL_FIELD = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
            REF_PRIVATE_FINAL_FIELD = TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
            REF_PRIVATE_FINAL_FIELD.setAccessible(true);

            REF_PUBLIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
            REF_PRIVATE_FIELD = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
            REF_PRIVATE_FIELD.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
