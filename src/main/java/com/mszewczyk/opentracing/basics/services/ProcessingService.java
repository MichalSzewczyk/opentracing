package com.mszewczyk.opentracing.basics.services;

import com.mszewczyk.opentracing.basics.utils.DemoUtils;
import io.opentracing.Scope;
import io.opentracing.Tracer;

public class ProcessingService {
    private final DatabaseConnector databaseConnector;
    private final Tracer tracer;

    public ProcessingService(DatabaseConnector databaseConnector, Tracer tracer) {
        this.databaseConnector = databaseConnector;
        this.tracer = tracer;
    }

    public void preProcess() {
        try (Scope scope = tracer.buildSpan("pre-process")
                .asChildOf(tracer.activeSpan())
                .startActive(true)) {
            DemoUtils.executeLongRunningTask();
        }
    }

    public void process() {
        try (Scope scope = tracer.buildSpan("process")
                .asChildOf(tracer.activeSpan())
                .startActive(true)) {
            DemoUtils.executeShortRunningTask();
            databaseConnector.storeData();
            DemoUtils.executeShortRunningTask();
        }
    }

    public void postProcess() {
        try (Scope scope = tracer.buildSpan("post-process")
                .asChildOf(tracer.activeSpan())
                .startActive(true)) {
            DemoUtils.executeLongRunningTask();
        }
    }
}