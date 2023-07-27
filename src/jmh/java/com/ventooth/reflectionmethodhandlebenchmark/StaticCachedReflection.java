package com.ventooth.reflectionmethodhandlebenchmark;

import java.lang.reflect.Field;

public final class StaticCachedReflection {
    public static final Field PUBLIC_FINAL_STATIC_FIELD;
    public static final Field PRIVATE_FINAL_STATIC_FIELD;

    public static final Field PUBLIC_STATIC_FIELD;
    public static final Field PRIVATE_STATIC_FIELD;

    static {
        try {
            PUBLIC_FINAL_STATIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
            PRIVATE_FINAL_STATIC_FIELD = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
            PRIVATE_FINAL_STATIC_FIELD.setAccessible(true);

            PUBLIC_STATIC_FIELD = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
            PRIVATE_STATIC_FIELD = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
            PRIVATE_STATIC_FIELD.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
