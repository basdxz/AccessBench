package com.ventooth.accessbench;

import lombok.NoArgsConstructor;
import lombok.val;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 0, time = 5)
@Measurement(iterations = 1, time = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 120)
@Fork(0)
@NoArgsConstructor
public class StaticCachedBenchmark {
    @Benchmark
    public void reflectionPublicStaticFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivateStaticFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
        field.setAccessible(true);
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPublicStatic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivateStatic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
        field.setAccessible(true);
        val value = field.get(null);
        bh.consume(value);
    }
    
    @Benchmark
    public void methodHandlePublicStaticFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_STATIC_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePrivateStaticFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_STATIC_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePublicStatic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_STATIC_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact();
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePrivateStatic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_STATIC_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact();
        bh.consume(value);
    }
}
