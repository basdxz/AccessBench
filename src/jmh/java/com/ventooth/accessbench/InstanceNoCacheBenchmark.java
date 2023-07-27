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
public class InstanceNoCacheBenchmark {
    private TargetClass targetInstance;

    @Setup(Level.Iteration)
    public void setupTargetInstance() {
        targetInstance = new TargetClass();
    }

    @Benchmark
    public void reflectionPublicFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
        val value = field.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivateFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
        field.setAccessible(true);
        val value = field.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPublic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
        val value = field.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivate(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
        field.setAccessible(true);
        val value = field.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePublicFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FINAL_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePrivateFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FINAL_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePublic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PUBLIC_FIELD");
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePrivate(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getDeclaredField("PRIVATE_FIELD");
        field.setAccessible(true);
        val mh = MethodHandles.lookup().unreflectGetter(field);
        val value = (String)mh.invokeExact(targetInstance);
        bh.consume(value);
    }
}
