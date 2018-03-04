package com.mszewczyk.opentracing.basics.utils;

import brave.Tracing;
import brave.opentracing.BraveTracer;
import brave.sampler.Sampler;
import io.opentracing.Tracer;
import zipkin.Span;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.okhttp3.OkHttpSender;

public class TracingUtils {
    public static Tracer initializeTracer(String reporterEndpoint) {
        OkHttpSender okHttpSender = OkHttpSender.create(reporterEndpoint);
        AsyncReporter<Span> reporter = AsyncReporter.builder(okHttpSender).build();
        Tracing braveTracer = Tracing.newBuilder().sampler(Sampler.ALWAYS_SAMPLE).localServiceName("tracing-example").reporter(reporter).build();
        return BraveTracer.create(braveTracer);
    }
}
