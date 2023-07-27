package com.ventooth.accessbench.reflect;

import com.ventooth.accessbench.TargetClass;
import lombok.NoArgsConstructor;
import lombok.val;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static com.ventooth.accessbench.TargetInstanceContainer.*;
import static com.ventooth.accessbench.reflect.ReflectInstanceCache.*;
import static com.ventooth.accessbench.reflect.ReflectStaticCache.*;

@NoArgsConstructor
@State(Scope.Benchmark)
public class ReflectBench {
    @Benchmark
    public void reflectPublicStaticFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
        field.setAccessible(true);
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicStaticNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
        field.setAccessible(true);
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
        val value = field.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
        field.setAccessible(true);
        val value = field.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
        val value = field.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
        field.setAccessible(true);
        val value = field.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicStaticFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_FINAL_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_FINAL_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicStaticWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_FINAL_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_FINAL_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateWithStaticCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicStaticFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PUBLIC_FINAL_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PRIVATE_FINAL_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicStaticWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PUBLIC_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PRIVATE_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PUBLIC_FINAL_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PRIVATE_FINAL_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PUBLIC_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateWithInstanceCache(Blackhole bh) throws Throwable {
        val value = REFLECT_INSTANCE_CACHE.REF_PRIVATE_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }
}
