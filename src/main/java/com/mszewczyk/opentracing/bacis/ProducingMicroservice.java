package com.mszewczyk.opentracing.bacis;

import java.util.ArrayList;
import java.util.List;

public class ProducingMicroservice {
    private final ProcessingEngine processingEngine;
    private final List<Subscriber> subscribers;

    public ProducingMicroservice(ProcessingEngine processingEngine) {
        this.processingEngine = processingEngine;
        this.subscribers = new ArrayList<>();
    }

    void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    void sendNotification() {
        processingEngine.preProcess();
        processingEngine.process();
        processingEngine.postProcess();

        subscribers.forEach(Subscriber::sendNotification);
    }
}
