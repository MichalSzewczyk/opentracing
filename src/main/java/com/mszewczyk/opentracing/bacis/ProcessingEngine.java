package com.mszewczyk.opentracing.bacis;

public interface ProcessingEngine {
    void preProcess();

    void process();

    void postProcess();
}
