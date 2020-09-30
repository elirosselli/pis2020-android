package com.pack.sdk;

import types.TypeResponse;

public interface RequestsCallback {

    public void onSuccess(TypeResponse response);

    public void onError(TypeResponse response);

}
