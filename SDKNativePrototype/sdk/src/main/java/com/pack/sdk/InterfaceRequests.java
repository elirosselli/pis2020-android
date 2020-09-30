package com.pack.sdk;

import types.TypeRequest;
import types.TypeResponse;

public interface InterfaceRequests {
    void makeRequest(TypeRequest rq, RequestsCallback callback);
}
