package com.mszewczyk.opentracing.basics.requests;

import com.mszewczyk.opentracing.basics.services.Service;

public interface Request {
    void handleWith(Service service);
}
