package com.ventooth.accessbench.reflect;

import com.ventooth.accessbench.TargetClass;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public final class ReflectInstanceCache {
    public static final Field REF_PUBLIC_FINAL_FIELD;
    public static final Field REF_PRIVATE_FINAL_FIELD;

    public static final Field REF_PUBLIC_FIELD;
    public static final Field REF_PRIVATE_FIELD;

    static {
        try {
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
