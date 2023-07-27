package com.ventooth.reflectionmethodhandlebenchmark;

import lombok.NoArgsConstructor;
import lombok.val;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 0, time = 5)
@Measurement(iterations = 1, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
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
        val field = TargetClass.class.getField("PUBLIC_FINAL_FIELD");
        val value = field.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivateFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getField("PUBLIC_FINAL_FIELD");
        field.setAccessible(true);
        val value = field.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPublic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getField("PUBLIC_FINAL_FIELD");
        val value = field.get(targetInstance);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivate(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getField("PUBLIC_FINAL_FIELD");
        field.setAccessible(true);
        val value = field.get(targetInstance);
        bh.consume(value);
    }
}
