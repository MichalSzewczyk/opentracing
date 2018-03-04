package com.mszewczyk.opentracing.basics.requests;

import com.mszewczyk.opentracing.basics.services.ProcessingService;
import com.mszewczyk.opentracing.basics.services.Service;
import io.opentracing.Scope;
import io.opentracing.Tracer;

public class LongRunningRequest implements Request {
    private final ProcessingService processingService;
    private final Tracer tracer;

    public LongRunningRequest(ProcessingService processingService, Tracer tracer) {
        this.processingService = processingService;
        this.tracer = tracer;
    }

    @Override
    public void handleWith(Service service) {
        try (Scope scope = tracer.buildSpan("perform-long-running-request")
                .asChildOf(tracer.activeSpan())
                .startActive(true)) {
            service.run(() -> {
                processingService.preProcess();
                processingService.process();
                processingService.postProcess();
            });
        }
    }
}
