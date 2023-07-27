package com.ventooth.accessbench;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class TargetClass {
    public static final String PUBLIC_FINAL_STATIC_FIELD = "DEFAULT_VALUE";
    private static final String PRIVATE_FINAL_STATIC_FIELD = "DEFAULT_VALUE";

    public static String PUBLIC_STATIC_FIELD = "DEFAULT_VALUE";
    private static String PRIVATE_STATIC_FIELD = "DEFAULT_VALUE";

    public final String PUBLIC_FINAL_FIELD = "DEFAULT_VALUE";
    private final String PRIVATE_FINAL_FIELD = "DEFAULT_VALUE";

    public String PUBLIC_FIELD = "DEFAULT_VALUE";
    private String PRIVATE_FIELD = "DEFAULT_VALUE";
}
