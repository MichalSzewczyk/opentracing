package com.mszewczyk.opentracing.basics;

import com.mszewczyk.opentracing.basics.requests.LongRunningRequest;
import com.mszewczyk.opentracing.basics.requests.Request;
import com.mszewczyk.opentracing.basics.services.DatabaseConnector;
import com.mszewczyk.opentracing.basics.services.ExecutingService;
import com.mszewczyk.opentracing.basics.services.ProcessingService;
import com.mszewczyk.opentracing.basics.services.Service;
import com.mszewczyk.opentracing.basics.utils.TracingUtils;
import io.opentracing.Tracer;

public class LogicRoot {
    public static void main(String[] args) {
        Tracer tracer = TracingUtils.initializeTracer("http://192.168.238.137:9411/api/v1/spans");
        Service service = new ExecutingService(tracer);
        ProcessingService processingService = new ProcessingService(new DatabaseConnector(tracer), tracer);
        Request request = new LongRunningRequest(processingService, tracer);
        request.handleWith(service);
    }
}
