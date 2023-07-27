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

@State(Scope.Benchmark)
@Warmup(iterations = 0, time = 5)
@Measurement(iterations = 1, time = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 120)
@Fork(0)
@NoArgsConstructor
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
    public void reflectPublicStaticFinalWithCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_FINAL_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticFinalWithCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_FINAL_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicStaticWithCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateStaticWithCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_STATIC_FIELD.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicFinalWithCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_FINAL_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateFinalWithCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_FINAL_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPublicWithCache(Blackhole bh) throws Throwable {
        val value = REF_PUBLIC_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void reflectPrivateWithCache(Blackhole bh) throws Throwable {
        val value = REF_PRIVATE_FIELD.get(TARGET_INSTANCE);
        bh.consume(value);
    }
}
