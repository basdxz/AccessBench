package com.ventooth.accessbench.baseline;

import com.ventooth.accessbench.TargetClass;
import com.ventooth.accessbench.TargetInstanceContainer;
import lombok.NoArgsConstructor;
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
public class BaselineBench {
    @Benchmark
    public void baselinePublicStaticFinal(Blackhole bh) {
        bh.consume(TargetClass.PUBLIC_FINAL_STATIC_FIELD);
    }

    @Benchmark
    public void baselinePublicStatic(Blackhole bh) {
        bh.consume(TargetClass.PUBLIC_STATIC_FIELD);
    }

    @Benchmark
    public void baselinePublicFinal(Blackhole bh) {
        bh.consume(TargetInstanceContainer.TARGET_INSTANCE.PUBLIC_FINAL_FIELD);
    }

    @Benchmark
    public void baselinePublic(Blackhole bh) {
        bh.consume(TargetInstanceContainer.TARGET_INSTANCE.PUBLIC_FIELD);
    }
}
