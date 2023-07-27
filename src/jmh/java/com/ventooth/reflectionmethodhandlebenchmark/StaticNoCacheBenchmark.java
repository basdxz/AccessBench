package com.ventooth.reflectionmethodhandlebenchmark;

import lombok.NoArgsConstructor;
import lombok.val;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 0, time = 5)
@Measurement(iterations = 1, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 120)
@Fork(0)
@NoArgsConstructor
public class StaticNoCacheBenchmark {
    @Benchmark
    public void reflectionPublicStaticFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getField("PUBLIC_FINAL_STATIC_FIELD");
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivateStaticFinal(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getField("PUBLIC_FINAL_STATIC_FIELD");
        field.setAccessible(true);
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPublicStatic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getField("PUBLIC_FINAL_STATIC_FIELD");
        val value = field.get(null);
        bh.consume(value);
    }

    @Benchmark
    public void reflectionPrivateStatic(Blackhole bh) throws Throwable {
        val field = TargetClass.class.getField("PUBLIC_FINAL_STATIC_FIELD");
        field.setAccessible(true);
        val value = field.get(null);
        bh.consume(value);
    }
}
