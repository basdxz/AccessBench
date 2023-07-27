package com.ventooth.accessbench.invoke;

import com.ventooth.accessbench.TargetClass;
import lombok.NoArgsConstructor;
import lombok.val;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

import static com.ventooth.accessbench.TargetInstanceContainer.TARGET_INSTANCE;
import static com.ventooth.accessbench.invoke.InvokeInstanceCache.INVOKE_INSTANCE_CACHE;
import static com.ventooth.accessbench.invoke.InvokeStaticCache.*;

@State(Scope.Benchmark)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 1, time = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 120)
@Fork(0)
@NoArgsConstructor
public class InvokeBench {
    @Benchmark
    public void invokePublicStaticFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateStaticFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokePublicStaticNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateStaticNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokePublicFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateFinalNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePublicNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateNoCache(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String) mh.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPublicFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PUBLIC_FINAL_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPrivateFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PRIVATE_FINAL_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPublicWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PUBLIC_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPrivateWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PRIVATE_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokePublicFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PUBLIC_FINAL_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateFinalWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PRIVATE_FINAL_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePublicWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PUBLIC_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateWithStaticCache(Blackhole bh) throws Throwable {
        val value = (String) INV_PRIVATE_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPublicFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PUBLIC_FINAL_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPrivateFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PRIVATE_FINAL_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPublicWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PUBLIC_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokeStaticPrivateWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PRIVATE_STATIC_FIELD.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void invokePublicFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PUBLIC_FINAL_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateFinalWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PRIVATE_FINAL_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePublicWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PUBLIC_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }

    @Benchmark
    public void invokePrivateWithInstanceCache(Blackhole bh) throws Throwable {
        val value = (String) INVOKE_INSTANCE_CACHE.INV_PRIVATE_FIELD.invokeExact(TARGET_INSTANCE);
        bh.consume(value);
    }
}
