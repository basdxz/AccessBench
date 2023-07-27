package com.ventooth.reflectionmethodhandlebenchmark;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public final class InstanceCachedReflection {
    public static final Field PUBLIC_FINAL_FIELD;
    public static final Field PRIVATE_FINAL_FIELD;

    public static final Field PUBLIC_FIELD;
    public static final Field PRIVATE_FIELD;

    static {
        try {
            PUBLIC_FINAL_FIELD = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
            PRIVATE_FINAL_FIELD = TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
            PRIVATE_FINAL_FIELD.setAccessible(true);

            PUBLIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
            PRIVATE_FIELD = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
            PRIVATE_FIELD.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
