package com.mszewczyk.opentracing.basics.services;

import io.opentracing.Scope;
import io.opentracing.Tracer;

public class ExecutingService implements Service {
    private final Tracer tracer;

    public ExecutingService(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public void run(Runnable task) {
        try (Scope scope = tracer.buildSpan("executing-task")
                .startActive(true)) {
            task.run();
        }
    }
}
