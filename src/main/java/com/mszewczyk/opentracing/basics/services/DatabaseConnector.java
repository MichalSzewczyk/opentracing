package com.mszewczyk.opentracing.basics.services;

import com.mszewczyk.opentracing.basics.utils.DemoUtils;
import io.opentracing.Scope;
import io.opentracing.Tracer;

public class DatabaseConnector {
    private final Tracer tracer;

    public DatabaseConnector(Tracer tracer) {
        this.tracer = tracer;
    }

    void storeData() {
        try (Scope scope = tracer.buildSpan("store-data")
                .asChildOf(tracer.activeSpan())
                .startActive(true)) {
            DemoUtils.executeLongRunningTask();
        }
    }
}