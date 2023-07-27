package com.ventooth.accessbench;

import lombok.NoArgsConstructor;
import lombok.val;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 0, time = 5)
@Measurement(iterations = 1, time = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 120)
@Fork(0)
@NoArgsConstructor
public class InstanceCachedBenchmark {
    private TargetClass targetInstance;

    @Setup(Level.Iteration)
    public void setupTargetInstance() {
        targetInstance = new TargetClass();
    }

    @Benchmark
    public void reflectionPublicFinal(Blackhole bh) throws Throwable {
        val value = InstanceCachedReflection.PUBLIC_FINAL_FIELD.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivateFinal(Blackhole bh) throws Throwable {
        val value = InstanceCachedReflection.PRIVATE_FINAL_FIELD.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPublic(Blackhole bh) throws Throwable {
        val value = InstanceCachedReflection.PUBLIC_FIELD.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivate(Blackhole bh) throws Throwable {
        val value = InstanceCachedReflection.PRIVATE_FIELD.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePublicFinal(Blackhole bh) throws Throwable {
        val value = (String)InstanceCachedMethodHandles.PUBLIC_FINAL_FIELD.invokeExact(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePrivateFinal(Blackhole bh) throws Throwable {
        val value = (String)InstanceCachedMethodHandles.PRIVATE_FINAL_FIELD.invokeExact(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePublic(Blackhole bh) throws Throwable {
        val value = (String)InstanceCachedMethodHandles.PUBLIC_FIELD.invokeExact(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void methodHandlePrivate(Blackhole bh) throws Throwable {
        val value = (String)InstanceCachedMethodHandles.PRIVATE_FIELD.invokeExact(targetInstance);
        bh.consume(value);
    }
}
