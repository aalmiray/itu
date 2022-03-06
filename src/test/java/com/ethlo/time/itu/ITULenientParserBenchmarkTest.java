package com.ethlo.time.itu;

/*-
 * #%L
 * Internet Time Utility
 * %%
 * Copyright (C) 2017 - 2022 Morten Haraldsen (ethlo)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import com.ethlo.time.EthloITU;

@Warmup(iterations = 1, time = 30)
@BenchmarkMode(Mode.SampleTime)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ITULenientParserBenchmarkTest
{
    private static final EthloITU ethloItu = new EthloITU();

    @Benchmark
    public void parseRawYear(final Blackhole blackhole)
    {
        blackhole.consume(ethloItu.parse("2017"));
    }

    @Benchmark
    public void parseRawMonth(final Blackhole blackhole)
    {
        blackhole.consume(ethloItu.parse("2017-12"));
    }

    @Benchmark
    public void parseRawDay(final Blackhole blackhole)
    {
        blackhole.consume(ethloItu.parse("2017-12-21"));
    }

    @Benchmark
    public void parseRawMinute(final Blackhole blackhole)
    {
        blackhole.consume(ethloItu.parse("2017-12-21T12:20Z"));
    }

    @Benchmark
    public void parseRawSecond(final Blackhole blackhole)
    {
        blackhole.consume(ethloItu.parse("2017-12-21T12:20:45Z"));
    }
}
