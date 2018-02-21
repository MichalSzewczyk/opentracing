package com.mszewczyk.opentracing.bacis;

public class DefaultProcessingEngine implements ProcessingEngine {
    private static final int ONE_SECOND = 1000;

    @Override
    public void preProcess() {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process() {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postProcess() {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
